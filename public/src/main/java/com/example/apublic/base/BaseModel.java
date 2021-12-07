package com.example.apublic.base;

import android.os.Build;

import com.example.apublic.utils.L;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class BaseModel<T,R extends BaseModel> {
    private static final String TAG = "BaseModel";
    private T service;
    private Retrofit retrofit;

    public BaseModel(String url) {
        L.i(TAG, "BaseModel:::::" + url);
        retrofit = getRetrofit(url);
        service = retrofit.create(getServiceClass());
    }

    private Retrofit getRetrofit(String url) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
//                .addInterceptor(new MoreBaseUrlInterceptor(Config.BASE_URL))
                .addInterceptor(createHttpLoggingInterceptor());
        builder.hostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        });
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT_WATCH) {
            try {
                TrustManager[] tm = new TrustManager[]{new SsX509TrustManager()};
                SSLSocketFactory socketFactory = new Tls12SocketFactory(null, tm, new SecureRandom());
                builder.sslSocketFactory(socketFactory, (X509TrustManager) tm[0]);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (KeyManagementException e) {
                e.printStackTrace();
            }
        }
        OkHttpClient client = builder.build();
        return new Retrofit.Builder()
                .baseUrl(Config.BASE_URL)
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    private static Interceptor createHttpLoggingInterceptor() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(Boolean.parseBoolean("true") ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
        return loggingInterceptor;
    }

    public class Tls12SocketFactory extends SSLSocketFactory {
        private SSLSocketFactory internalSSLSocketFactory;

        private SSLContext context;

        public Tls12SocketFactory(KeyManager[] km, TrustManager[] tm, SecureRandom sr) throws KeyManagementException, NoSuchAlgorithmException {
            context = SSLContext.getInstance("TLSv1.2");
            context.init(km, tm, sr);
            internalSSLSocketFactory = context.getSocketFactory();
        }

        @Override
        public String[] getDefaultCipherSuites() {
            return internalSSLSocketFactory.getDefaultCipherSuites();
        }

        @Override
        public String[] getSupportedCipherSuites() {
            return internalSSLSocketFactory.getSupportedCipherSuites();
        }

        @Override
        public Socket createSocket(Socket s, String host, int port, boolean autoClose) throws IOException {
            SSLSocket sslSocket = (SSLSocket) context.getSocketFactory().createSocket(s, host, port, autoClose);
            sslSocket.setEnabledProtocols(new String[]{"TLSv1.2"});
            return sslSocket;
        }

        @Override
        public Socket createSocket(String host, int port) throws IOException, UnknownHostException {
            SSLSocket sslSocket = (SSLSocket) context.getSocketFactory().createSocket(host, port);
            sslSocket.setEnabledProtocols(new String[]{"TLSv1.2"});
            return sslSocket;
        }

        @Override
        public Socket createSocket(String host, int port, InetAddress localHost, int localPort) throws IOException, UnknownHostException {
            SSLSocket sslSocket = (SSLSocket) context.getSocketFactory().createSocket(host, port, localHost, localPort);
            sslSocket.setEnabledProtocols(new String[]{"TLSv1.2"});
            return sslSocket;
        }

        @Override
        public Socket createSocket(InetAddress host, int port) throws IOException {
            SSLSocket sslSocket = (SSLSocket) context.getSocketFactory().createSocket(host, port);
            sslSocket.setEnabledProtocols(new String[]{"TLSv1.2"});
            return sslSocket;
        }

        @Override
        public Socket createSocket(InetAddress address, int port, InetAddress localAddress, int localPort) throws IOException {
            SSLSocket sslSocket = (SSLSocket) context.getSocketFactory().createSocket(address, port, localAddress, localPort);
            sslSocket.setEnabledProtocols(new String[]{"TLSv1.2"});
            return sslSocket;
        }
    }

    public class SsX509TrustManager implements X509TrustManager {

        @Override
        public void checkClientTrusted(java.security.cert.X509Certificate[] x509Certificates, String s) throws java.security.cert.CertificateException {
        }

        @Override
        public void checkServerTrusted(java.security.cert.X509Certificate[] x509Certificates, String s) throws java.security.cert.CertificateException {
        }

        @Override
        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return new java.security.cert.X509Certificate[0];
        }
    }

    public T getService() {
        return service;
    }

    protected abstract Class<T> getServiceClass();


}

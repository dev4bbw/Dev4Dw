package com.example.dev4dw.utils;

public class ImageUtil {
    /**懒汉式**/
    private static ImageUtil instance;
    private ImageUtil(){

    }

    /**
     * 多线程安全：否
      * @return
     */
    public static ImageUtil getInstance(){
        if (instance==null){
            instance = new ImageUtil();
        }
        return instance;
    }

    /**
     * 多线程安全：是
     * @return
     */
    public synchronized static ImageUtil getSaveInstance(){
        if (instance==null){
            instance = new ImageUtil();
        }
        return instance;
    }
    /**懒汉式**/
    /**饿汉式**/
    private static ImageUtil instanceH = new ImageUtil();

    /**
     * 多线程安全：是
     * @return
     */
    public static ImageUtil getHInstance(){
        return instanceH;
    }
    /**饿汉式**/

}

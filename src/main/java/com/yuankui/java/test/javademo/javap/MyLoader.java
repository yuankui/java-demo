package com.yuankui.java.test.javademo.javap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.ByteBuffer;

public class MyLoader extends URLClassLoader {
    private final String path;

    public MyLoader(String path) {
        super(new URL[]{});
        this.path = path;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            return super.findClass(name);
        } catch (ClassNotFoundException e) {
            // ignore
        }
        String file = name.replace(".", "/") + ".class";

        try {
            FileInputStream stream = new FileInputStream(path + "/" + file);
            ByteBuffer byteBuffer = ByteBuffer.allocate(1000 * 1000 * 20);

            byte[] tmp = new byte[100];
            while (true) {
                int read = stream.read(tmp);
                if (read <= 0) {
                    break;
                }

                byteBuffer.put(tmp, 0, read);
            }

            byteBuffer.flip();

            Class<?> clazz = this.defineClass(name, byteBuffer.array(), byteBuffer.position(), byteBuffer.limit() - byteBuffer.position());
            if (clazz != null) {
                return clazz;
            }

            throw new ClassNotFoundException(name);

        } catch (FileNotFoundException e) {
            throw new ClassNotFoundException(name);
        } catch (IOException e) {
            throw new ClassNotFoundException(e.getMessage());
        }

    }
}

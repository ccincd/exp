package toy.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

import io.crate.shade.com.google.common.base.Charsets;

/**
 * IOUtilsTest
 *
 * @author chi.chen
 * @date 16-3-1
 * @time 上午10:08
 */
public class IOUtilsTest {

    public static void main(String[] args) {
        try {
            BufferedInputStream inputStream = new BufferedInputStream(
                    new FileInputStream("/home/chichen/桌面/TODO LIST"));

            System.out.println(IOUtils.toString(inputStream, Charsets.UTF_8.name()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

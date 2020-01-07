package com.yuankui.java.test.javademo.rxjava2;

import com.github.davidmoten.rx.jdbc.Database;
import retrofit2.Call;
import rx.Observable;
import rx.observables.BlockingObservable;

import java.util.Arrays;
import java.util.Map;

public class RxJavaJdbcTest {
    public static void main(String[] args) {
        String url = "jdbc:mysql://10.24.76.171:5002/waimai_d_profileplatform" +
                "?characterEncoding=UTF8" +
                "&socketTimeout=60000" +
                "&allowMultiQueries=true" +
                "&user=waimai_d_profileplatform" +
                "&password=291%23QSNtel";
        
        Database db = Database.from(url);
        db.select("select id, name from profile_label limit 10")
                .getTupleN()
                .forEach(o -> {
                    System.out.println("o = " + o);
                });

        Call<String> c = null;
    }
}

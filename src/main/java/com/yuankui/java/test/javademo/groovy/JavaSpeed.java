package com.yuankui.java.test.javademo.groovy;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.stream.Stream;

public class JavaSpeed {
    public static void main(String[] args) {
        String str; 
        {
            str = "{\n" +
                    "    \"msg\": {\n" +
                    "        \"productCount\": 91,\n" +
                    "        \"userId\": 251247340,\n" +
                    "        \"wmShoppingCartPoiAndProductsList\": [\n" +
                    "            {\n" +
                    "                \"wmShoppingCartPoi\": {\n" +
                    "                    \"cityId\": 530100,\n" +
                    "                    \"ctime\": 1578993697,\n" +
                    "                    \"name\": \"小宅门火锅冒菜（南屏街店）\",\n" +
                    "                    \"operation\": \"OPERATION_INSERT\",\n" +
                    "                    \"picUrl\": \"http://p0.meituan.net/waimaipoi/a89de223ef46cb21020e1821c08515e9249721.jpg\",\n" +
                    "                    \"userId\": 251247340,\n" +
                    "                    \"utime\": 1578993697,\n" +
                    "                    \"valid\": 1,\n" +
                    "                    \"wmPoiId\": 7949443\n" +
                    "                },\n" +
                    "                \"wmShoppingCartProductMap\": {\n" +
                    "                    \"2097654866\": {\n" +
                    "                        \"attrIds\": \"\",\n" +
                    "                        \"boxCount\": 1,\n" +
                    "                        \"boxPrice\": 0.2,\n" +
                    "                        \"checkStatus\": 1,\n" +
                    "                        \"count\": 1,\n" +
                    "                        \"ctime\": 1578993737,\n" +
                    "                        \"discription\": \"\",\n" +
                    "                        \"identityHashcode\": 0,\n" +
                    "                        \"name\": \"午餐肉\",\n" +
                    "                        \"operation\": \"OPERATION_INSERT\",\n" +
                    "                        \"originalPrice\": 1.2,\n" +
                    "                        \"picUrl\": \"http://p0.meituan.net/wmproduct/fb9120fb574cccbcb56b6bc72af0c96c1029562.png\",\n" +
                    "                        \"skuId\": 2097654866,\n" +
                    "                        \"userId\": 251247340,\n" +
                    "                        \"utime\": 1578993737,\n" +
                    "                        \"valid\": 1,\n" +
                    "                        \"wmPoiId\": 7949443\n" +
                    "                    },\n" +
                    "                    \"2097518381:1789588553\": {\n" +
                    "                        \"attrIds\": \"1789588553\",\n" +
                    "                        \"boxCount\": 1,\n" +
                    "                        \"boxPrice\": 2.0,\n" +
                    "                        \"checkStatus\": 1,\n" +
                    "                        \"count\": 1,\n" +
                    "                        \"ctime\": 1578993738,\n" +
                    "                        \"discription\": \"\",\n" +
                    "                        \"identityHashcode\": 0,\n" +
                    "                        \"name\": \"【午餐肉+时蔬】套餐（配米饭)\",\n" +
                    "                        \"operation\": \"OPERATION_INSERT\",\n" +
                    "                        \"originalPrice\": 26.0,\n" +
                    "                        \"picUrl\": \"http://p0.meituan.net/wmproduct/391db20baff571b4400dbae1cc5f77ce2663700.png\",\n" +
                    "                        \"skuId\": 2097518381,\n" +
                    "                        \"userId\": 251247340,\n" +
                    "                        \"utime\": 1578993738,\n" +
                    "                        \"valid\": 1,\n" +
                    "                        \"wmPoiId\": 7949443\n" +
                    "                    }\n" +
                    "                }\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"wmShoppingCartPoi\": {\n" +
                    "                    \"cityId\": 530100,\n" +
                    "                    \"ctime\": 1578993696,\n" +
                    "                    \"name\": \"胖师兄\",\n" +
                    "                    \"operation\": \"OPERATION_INSERT\",\n" +
                    "                    \"picUrl\": \"http://p1.meituan.net/business/725085bffe3899df7303b7f2d0d1952c92127.jpg\",\n" +
                    "                    \"userId\": 251247340,\n" +
                    "                    \"utime\": 1578993696,\n" +
                    "                    \"valid\": 1,\n" +
                    "                    \"wmPoiId\": 7733997\n" +
                    "                },\n" +
                    "                \"wmShoppingCartProductMap\": {\n" +
                    "                    \"2101922758\": {\n" +
                    "                        \"attrIds\": \"\",\n" +
                    "                        \"boxCount\": 1,\n" +
                    "                        \"boxPrice\": 2.0,\n" +
                    "                        \"checkStatus\": 1,\n" +
                    "                        \"count\": 1,\n" +
                    "                        \"ctime\": 1578993736,\n" +
                    "                        \"discription\": \"\",\n" +
                    "                        \"identityHashcode\": 0,\n" +
                    "                        \"name\": \"三鲜砂锅菜套饭\",\n" +
                    "                        \"operation\": \"OPERATION_INSERT\",\n" +
                    "                        \"originalPrice\": 21.0,\n" +
                    "                        \"picUrl\": \"http://p1.meituan.net/wmproduct/bc510a7105e3e818a3df73d46e4acd52304978.jpg\",\n" +
                    "                        \"skuId\": 2101922758,\n" +
                    "                        \"userId\": 251247340,\n" +
                    "                        \"utime\": 1578993736,\n" +
                    "                        \"valid\": 1,\n" +
                    "                        \"wmPoiId\": 7733997\n" +
                    "                    }\n" +
                    "                }\n" +
                    "            }\n" +
                    "        ]\n" +
                    "    },\n" +
                    "    \"msgType\": \"PRODUCT_SAVE_UPDATE\",\n" +
                    "    \"userId\": 251247340\n" +
                    "}";
        }

        JSONObject data = JSON.parseObject(str);


        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            if (!data.getString("msgType").equals("PRODUCT_SAVE_UPDATE")) {
                return;
            }

            if (!data.containsKey("msg") || data.getJSONObject("msg").getJSONArray("wmShoppingCartPoiAndProductsList") == null) {
                return;
            }

            data.getJSONObject("msg").getJSONArray("wmShoppingCartPoiAndProductsList")
                    .stream()
                    .flatMap(product -> {
                        JSONObject obj = (JSONObject) product;
                        if (obj == null) {
                            return Stream.empty();
                        }
                        return obj.getJSONObject("wmShoppingCartProductMap")
                                .entrySet()
                                .stream();
                    })
                    .forEach(kv -> {
                        Arrays.asList(kv.getKey(), kv.getValue());
                    });

            System.out.println("cost:" + (System.nanoTime() - start));
        }
        

    }
}

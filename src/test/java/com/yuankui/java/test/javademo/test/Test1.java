package com.yuankui.java.test.javademo.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.Map;
import java.util.stream.Collectors;

public class Test1 {
    @Test
    public void test() {
        String json = getJson();
        JSONObject obj = JSON.parseObject(json);
        Map<Integer, Long> intCount = obj.getJSONObject("data")
                .getJSONArray("labelAuthConfigs")
                .stream().filter(app -> {
                    JSONObject jsonObject = (JSONObject) app;
                    String appKey = jsonObject.getString("appKey");
                    if (appKey.contains("quake")) {
                        return false;
                    }
                    return true;
                })
                .flatMap(app -> {
                    return ((JSONObject) app).getJSONArray("labelIds").stream();
                }).map(i -> (int) i)
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));


        intCount.entrySet()
                .stream()
                .sorted((o1, o2) -> {
                    return o1.getValue().intValue() - o2.getValue().intValue();
                })
                .forEach(kv -> {
                    Integer k = kv.getKey();
                    Long v = kv.getValue();

                    System.out.print(k);
                    System.out.print("=>");
                    System.out.println(v);
                });

    }

    String getJson() {
        return "{\n" +
                "  \"code\": 0,\n" +
                "  \"data\": {\n" +
                "    \"labelAuthConfigs\": [\n" +
                "      {\n" +
                "        \"appKey\": \"com.sankuai.waimai.wmshpromotion.smtmktsv\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          160,\n" +
                "          133,\n" +
                "          10342,\n" +
                "          166,\n" +
                "          134,\n" +
                "          135,\n" +
                "          40,\n" +
                "          136,\n" +
                "          201,\n" +
                "          202,\n" +
                "          203,\n" +
                "          13,\n" +
                "          205,\n" +
                "          206,\n" +
                "          207,\n" +
                "          47,\n" +
                "          175,\n" +
                "          144,\n" +
                "          240,\n" +
                "          54,\n" +
                "          150,\n" +
                "          55,\n" +
                "          28\n" +
                "        ],\n" +
                "        \"secret\": \"56e6bcca2dff742f3cc880251af8f85e\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"com.sankuai.wmdmarketing.rank.server\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          71\n" +
                "        ],\n" +
                "        \"secret\": \"762e58acfbb2a348901c2ba2172656f3\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"com.sankuai.sgmkt.smartcontent\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          40,\n" +
                "          42\n" +
                "        ],\n" +
                "        \"secret\": \"61ec2182c874385f4dc29c98235b1930\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"com.sankuai.panlong.report\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          752,\n" +
                "          674,\n" +
                "          708,\n" +
                "          741,\n" +
                "          10342,\n" +
                "          742,\n" +
                "          168\n" +
                "        ],\n" +
                "        \"secret\": \"b838b3bb3da6227f1d741615432a9d63\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"com.sankuai.waimai.c.marketingprecsvcserver\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          133,\n" +
                "          134,\n" +
                "          135,\n" +
                "          71,\n" +
                "          10,\n" +
                "          206,\n" +
                "          47,\n" +
                "          207\n" +
                "        ],\n" +
                "        \"secret\": \"50f76607fe726890e662d389b3e64e79\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"com.sankuai.waimai.c.mig\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          240,\n" +
                "          10,\n" +
                "          719\n" +
                "        ],\n" +
                "        \"secret\": \"2f92cb86e913e82311c13f6493fcaaf9\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"com.sankuai.waimai.c.marketingprec\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          133,\n" +
                "          134,\n" +
                "          135,\n" +
                "          71,\n" +
                "          10,\n" +
                "          206,\n" +
                "          47,\n" +
                "          207\n" +
                "        ],\n" +
                "        \"secret\": \"15632345245ce3123f259dbf9081bb21\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"com.sankuai.waimai.c.algorithmcollector\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          10,\n" +
                "          10283,\n" +
                "          12,\n" +
                "          15\n" +
                "        ],\n" +
                "        \"secret\": \"a96b1a10de43341ac770852c85d1206a\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"com.sankuai.sgtcs.rank\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          64,\n" +
                "          65,\n" +
                "          133,\n" +
                "          69,\n" +
                "          70,\n" +
                "          71,\n" +
                "          136,\n" +
                "          139,\n" +
                "          140,\n" +
                "          141,\n" +
                "          206,\n" +
                "          207,\n" +
                "          144,\n" +
                "          722,\n" +
                "          19,\n" +
                "          150,\n" +
                "          25,\n" +
                "          153,\n" +
                "          26,\n" +
                "          156,\n" +
                "          160,\n" +
                "          98,\n" +
                "          166,\n" +
                "          40,\n" +
                "          106,\n" +
                "          107,\n" +
                "          46,\n" +
                "          239,\n" +
                "          175,\n" +
                "          49,\n" +
                "          50,\n" +
                "          52,\n" +
                "          116,\n" +
                "          54,\n" +
                "          55,\n" +
                "          124,\n" +
                "          125,\n" +
                "          126,\n" +
                "          63\n" +
                "        ],\n" +
                "        \"secret\": \"6de8943fa1d0bf044d5d3959ffbf00bf\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"com.sankuai.tsp.uds.apiconfig\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          10\n" +
                "        ],\n" +
                "        \"secret\": \"7a7aba2bb4dd08e422e61c17d71dd944\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"com.sankuai.waimai.ad\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          656,\n" +
                "          163,\n" +
                "          659,\n" +
                "          169,\n" +
                "          159\n" +
                "        ],\n" +
                "        \"secret\": \"493a206bbf8fe80e7e1c06d49bbdbe33\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"com.sankuai.waimai.d.horseracing\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          227,\n" +
                "          228,\n" +
                "          133,\n" +
                "          229,\n" +
                "          230,\n" +
                "          134,\n" +
                "          135,\n" +
                "          201,\n" +
                "          10,\n" +
                "          206,\n" +
                "          207,\n" +
                "          21,\n" +
                "          22\n" +
                "        ],\n" +
                "        \"secret\": \"65022861495a5a87bbe515a86cca02db\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"com.sankuai.wmdadinsite.adx\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          10,\n" +
                "          13,\n" +
                "          15\n" +
                "        ],\n" +
                "        \"secret\": \"29c1a4a33c4b9c79819e881095e376b2\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"com.sankuai.waimai.rank\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          209,\n" +
                "          210,\n" +
                "          10244,\n" +
                "          133,\n" +
                "          134,\n" +
                "          71,\n" +
                "          135,\n" +
                "          55,\n" +
                "          136,\n" +
                "          202,\n" +
                "          203\n" +
                "        ],\n" +
                "        \"secret\": \"a28fb09ac4837544d005bd64c214a4e8\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"com.sankuai.waimai.d.dspas\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          10,\n" +
                "          11,\n" +
                "          12,\n" +
                "          13,\n" +
                "          14,\n" +
                "          15,\n" +
                "          16,\n" +
                "          19,\n" +
                "          20,\n" +
                "          21,\n" +
                "          22,\n" +
                "          23,\n" +
                "          24,\n" +
                "          25,\n" +
                "          26,\n" +
                "          27,\n" +
                "          28,\n" +
                "          29,\n" +
                "          30,\n" +
                "          31,\n" +
                "          32,\n" +
                "          39,\n" +
                "          40,\n" +
                "          41,\n" +
                "          47,\n" +
                "          48,\n" +
                "          49,\n" +
                "          50,\n" +
                "          51,\n" +
                "          52,\n" +
                "          54,\n" +
                "          55,\n" +
                "          63,\n" +
                "          64,\n" +
                "          65,\n" +
                "          66,\n" +
                "          69,\n" +
                "          70,\n" +
                "          71,\n" +
                "          10342,\n" +
                "          107,\n" +
                "          108,\n" +
                "          109,\n" +
                "          110,\n" +
                "          115,\n" +
                "          116,\n" +
                "          122,\n" +
                "          123,\n" +
                "          124,\n" +
                "          125,\n" +
                "          126,\n" +
                "          127,\n" +
                "          128,\n" +
                "          129,\n" +
                "          130,\n" +
                "          131,\n" +
                "          132,\n" +
                "          133,\n" +
                "          134,\n" +
                "          135,\n" +
                "          136,\n" +
                "          137,\n" +
                "          138,\n" +
                "          139,\n" +
                "          140,\n" +
                "          141,\n" +
                "          142,\n" +
                "          143,\n" +
                "          144,\n" +
                "          145,\n" +
                "          146,\n" +
                "          658,\n" +
                "          147,\n" +
                "          659,\n" +
                "          148,\n" +
                "          149,\n" +
                "          150,\n" +
                "          151,\n" +
                "          152,\n" +
                "          153,\n" +
                "          154,\n" +
                "          155,\n" +
                "          156,\n" +
                "          157,\n" +
                "          158,\n" +
                "          159,\n" +
                "          160,\n" +
                "          161,\n" +
                "          162,\n" +
                "          163,\n" +
                "          164,\n" +
                "          165,\n" +
                "          166,\n" +
                "          167,\n" +
                "          168,\n" +
                "          169,\n" +
                "          170,\n" +
                "          171,\n" +
                "          710,\n" +
                "          711,\n" +
                "          712,\n" +
                "          713,\n" +
                "          714,\n" +
                "          206,\n" +
                "          212,\n" +
                "          213,\n" +
                "          214,\n" +
                "          215,\n" +
                "          216,\n" +
                "          240,\n" +
                "          753\n" +
                "        ],\n" +
                "        \"secret\": \"a520a3414f63af2be50f5e68eef9e063\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"com.sankuai.waimai.c.sourcecenter\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          133\n" +
                "        ],\n" +
                "        \"secret\": \"6443c8a09571c31cbc28e5225f27f360\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"com.sankuai.hoae.rta.matcher\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          10342,\n" +
                "          10363,\n" +
                "          10364\n" +
                "        ],\n" +
                "        \"secret\": \"b6fc313efa64810eb442b8362fba2c78\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"com.sankuai.waimai.c.marketingact\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          168,\n" +
                "          10\n" +
                "        ],\n" +
                "        \"secret\": \"41fd960fe681b25f9e144c6a4f44da21\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"com.sankuai.waimai.d.cpcats\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          10312,\n" +
                "          206\n" +
                "        ],\n" +
                "        \"secret\": \"7c2938ae9ab483416c6fe54b61721a5c\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"com.sankuai.waimai.ucenter\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          133,\n" +
                "          70,\n" +
                "          134,\n" +
                "          71,\n" +
                "          135,\n" +
                "          136,\n" +
                "          201,\n" +
                "          202,\n" +
                "          203,\n" +
                "          205,\n" +
                "          206,\n" +
                "          207,\n" +
                "          209,\n" +
                "          210,\n" +
                "          19,\n" +
                "          674,\n" +
                "          675,\n" +
                "          40,\n" +
                "          46,\n" +
                "          239,\n" +
                "          47,\n" +
                "          240,\n" +
                "          48,\n" +
                "          49,\n" +
                "          50,\n" +
                "          52,\n" +
                "          55\n" +
                "        ],\n" +
                "        \"secret\": \"3b53be26647a2c3c20caf6d6e9abd26c\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"com.sankuai.wmdmarketing.touchplatform\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          689,\n" +
                "          19,\n" +
                "          710,\n" +
                "          711,\n" +
                "          55\n" +
                "        ],\n" +
                "        \"secret\": \"0a48eae84d9befa574ebaeee7ace7f9e\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"com.sankuai.waimai.c.activity.web\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          135\n" +
                "        ],\n" +
                "        \"secret\": \"9e0fc00ad7627bcf58d651df0ff0d4ba\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"csc-waimai-service\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          663\n" +
                "        ],\n" +
                "        \"secret\": \"69c3c322803f41a1e03b1bede5ac9ec8\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"appkey:com.sankuai.canyinrc.r.data\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          50,\n" +
                "          52,\n" +
                "          133,\n" +
                "          679,\n" +
                "          40,\n" +
                "          136\n" +
                "        ],\n" +
                "        \"secret\": \"b7f65935ffe352fbe018fa23223f930c\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"com.sankuai.waimai.c.coupon\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          10\n" +
                "        ],\n" +
                "        \"secret\": \"21f960d9601edc39590c9f437e911a13\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"csc-ivr-platform-service\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          663\n" +
                "        ],\n" +
                "        \"secret\": \"4dfafbe5addf4e20ddbd42e6069db12d\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"com.sankuai.uds.api4feature\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          10309\n" +
                "        ],\n" +
                "        \"secret\": \"efb78beadeb3f8beda4cd01afccd0706\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"com.sankuai.ep.platform.quake\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          10,\n" +
                "          11,\n" +
                "          12,\n" +
                "          13,\n" +
                "          14,\n" +
                "          15,\n" +
                "          16,\n" +
                "          19,\n" +
                "          20,\n" +
                "          21,\n" +
                "          22,\n" +
                "          23,\n" +
                "          24,\n" +
                "          25,\n" +
                "          26,\n" +
                "          27,\n" +
                "          28,\n" +
                "          29,\n" +
                "          30,\n" +
                "          31,\n" +
                "          32,\n" +
                "          33,\n" +
                "          34,\n" +
                "          35,\n" +
                "          36,\n" +
                "          37,\n" +
                "          38,\n" +
                "          39,\n" +
                "          40,\n" +
                "          41,\n" +
                "          42,\n" +
                "          43,\n" +
                "          47,\n" +
                "          48,\n" +
                "          49,\n" +
                "          50,\n" +
                "          51,\n" +
                "          52,\n" +
                "          53,\n" +
                "          54,\n" +
                "          55,\n" +
                "          63,\n" +
                "          64,\n" +
                "          65,\n" +
                "          66,\n" +
                "          69,\n" +
                "          70,\n" +
                "          106,\n" +
                "          107,\n" +
                "          108,\n" +
                "          109,\n" +
                "          110,\n" +
                "          115,\n" +
                "          116,\n" +
                "          122,\n" +
                "          123,\n" +
                "          124,\n" +
                "          125,\n" +
                "          126,\n" +
                "          127,\n" +
                "          128,\n" +
                "          129,\n" +
                "          130,\n" +
                "          131,\n" +
                "          132,\n" +
                "          133,\n" +
                "          134,\n" +
                "          135,\n" +
                "          136,\n" +
                "          137,\n" +
                "          138,\n" +
                "          139,\n" +
                "          140,\n" +
                "          141,\n" +
                "          142,\n" +
                "          143,\n" +
                "          144,\n" +
                "          656,\n" +
                "          145,\n" +
                "          657,\n" +
                "          146,\n" +
                "          658,\n" +
                "          147,\n" +
                "          659,\n" +
                "          148,\n" +
                "          149,\n" +
                "          150,\n" +
                "          662,\n" +
                "          151,\n" +
                "          663,\n" +
                "          152,\n" +
                "          664,\n" +
                "          153,\n" +
                "          154,\n" +
                "          155,\n" +
                "          156,\n" +
                "          157,\n" +
                "          158,\n" +
                "          159,\n" +
                "          160,\n" +
                "          672,\n" +
                "          673,\n" +
                "          161,\n" +
                "          162,\n" +
                "          674,\n" +
                "          163,\n" +
                "          675,\n" +
                "          164,\n" +
                "          676,\n" +
                "          165,\n" +
                "          677,\n" +
                "          678,\n" +
                "          166,\n" +
                "          679,\n" +
                "          167,\n" +
                "          168,\n" +
                "          169,\n" +
                "          206,\n" +
                "          223,\n" +
                "          224,\n" +
                "          225,\n" +
                "          226,\n" +
                "          227,\n" +
                "          228,\n" +
                "          229,\n" +
                "          230,\n" +
                "          240\n" +
                "        ],\n" +
                "        \"secret\": \"96de5f964b35afb6623cde1c3e13d014\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"com.sankuai.wxeco.service\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          11360,\n" +
                "          11361,\n" +
                "          11362,\n" +
                "          11363,\n" +
                "          133,\n" +
                "          710,\n" +
                "          55,\n" +
                "          135,\n" +
                "          11356,\n" +
                "          11357,\n" +
                "          11358,\n" +
                "          11359\n" +
                "        ],\n" +
                "        \"secret\": \"7ffa667007514c3ea22a7c3c94cf89fc\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"com.sankuai.tsp.uds.api\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          10309\n" +
                "        ],\n" +
                "        \"secret\": \"8f12477657080ebcc4115ee9430b7268\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"com.sankuai.wmdrecsys.ms.dispatchservice\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          209,\n" +
                "          210,\n" +
                "          10244,\n" +
                "          133,\n" +
                "          134,\n" +
                "          71,\n" +
                "          135,\n" +
                "          55,\n" +
                "          136,\n" +
                "          202\n" +
                "        ],\n" +
                "        \"secret\": \"5a86354110fce5418c9e38f1b7919463\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"com.sankuai.mapinsight.d.sense\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          11521,\n" +
                "          10,\n" +
                "          11,\n" +
                "          12,\n" +
                "          13,\n" +
                "          14,\n" +
                "          15,\n" +
                "          16,\n" +
                "          17,\n" +
                "          18,\n" +
                "          19,\n" +
                "          20,\n" +
                "          21,\n" +
                "          22,\n" +
                "          23,\n" +
                "          24,\n" +
                "          25,\n" +
                "          26,\n" +
                "          27,\n" +
                "          28,\n" +
                "          29,\n" +
                "          30,\n" +
                "          31,\n" +
                "          32,\n" +
                "          33,\n" +
                "          34,\n" +
                "          35,\n" +
                "          36,\n" +
                "          37,\n" +
                "          38,\n" +
                "          39,\n" +
                "          40,\n" +
                "          10281,\n" +
                "          41,\n" +
                "          10282,\n" +
                "          42,\n" +
                "          43,\n" +
                "          10283,\n" +
                "          44,\n" +
                "          45,\n" +
                "          46,\n" +
                "          47,\n" +
                "          48,\n" +
                "          49,\n" +
                "          50,\n" +
                "          52,\n" +
                "          54,\n" +
                "          55,\n" +
                "          11580,\n" +
                "          63,\n" +
                "          64,\n" +
                "          65,\n" +
                "          66,\n" +
                "          11330,\n" +
                "          10309,\n" +
                "          11358,\n" +
                "          11359,\n" +
                "          11360,\n" +
                "          11361,\n" +
                "          11362,\n" +
                "          11364,\n" +
                "          10342,\n" +
                "          10343,\n" +
                "          104,\n" +
                "          10345,\n" +
                "          10346,\n" +
                "          10347,\n" +
                "          10348,\n" +
                "          10350,\n" +
                "          118,\n" +
                "          10362,\n" +
                "          10363,\n" +
                "          10364,\n" +
                "          124,\n" +
                "          125,\n" +
                "          126,\n" +
                "          10372,\n" +
                "          133,\n" +
                "          134,\n" +
                "          135,\n" +
                "          136,\n" +
                "          137,\n" +
                "          138,\n" +
                "          139,\n" +
                "          140,\n" +
                "          141,\n" +
                "          142,\n" +
                "          143,\n" +
                "          144,\n" +
                "          656,\n" +
                "          145,\n" +
                "          657,\n" +
                "          146,\n" +
                "          658,\n" +
                "          147,\n" +
                "          659,\n" +
                "          148,\n" +
                "          149,\n" +
                "          150,\n" +
                "          662,\n" +
                "          151,\n" +
                "          663,\n" +
                "          152,\n" +
                "          153,\n" +
                "          154,\n" +
                "          155,\n" +
                "          160,\n" +
                "          161,\n" +
                "          162,\n" +
                "          674,\n" +
                "          163,\n" +
                "          675,\n" +
                "          164,\n" +
                "          165,\n" +
                "          166,\n" +
                "          678,\n" +
                "          167,\n" +
                "          679,\n" +
                "          168,\n" +
                "          169,\n" +
                "          170,\n" +
                "          171,\n" +
                "          689,\n" +
                "          11441,\n" +
                "          703,\n" +
                "          708,\n" +
                "          709,\n" +
                "          711,\n" +
                "          713,\n" +
                "          714,\n" +
                "          205,\n" +
                "          206,\n" +
                "          719,\n" +
                "          720,\n" +
                "          721,\n" +
                "          722,\n" +
                "          10205,\n" +
                "          10206,\n" +
                "          10207,\n" +
                "          223,\n" +
                "          10208,\n" +
                "          224,\n" +
                "          225,\n" +
                "          10209,\n" +
                "          226,\n" +
                "          10210,\n" +
                "          10211,\n" +
                "          227,\n" +
                "          228,\n" +
                "          10212,\n" +
                "          229,\n" +
                "          10213,\n" +
                "          10214,\n" +
                "          230,\n" +
                "          10215,\n" +
                "          10216,\n" +
                "          10218,\n" +
                "          10219,\n" +
                "          10220,\n" +
                "          10222,\n" +
                "          10223,\n" +
                "          239,\n" +
                "          10224,\n" +
                "          753,\n" +
                "          10225,\n" +
                "          10230,\n" +
                "          10231,\n" +
                "          10232,\n" +
                "          10233,\n" +
                "          10234,\n" +
                "          11514,\n" +
                "          10235,\n" +
                "          10236\n" +
                "        ],\n" +
                "        \"secret\": \"ef03f923183520e675c5a88d66cf55da\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"com.sankuai.waimai.c.apicoreserver\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          133\n" +
                "        ],\n" +
                "        \"secret\": \"a0b301fcfb97b333e64ecee9e6d836cf\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"com.sankuai.mapinsight.d.aoi\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          42,\n" +
                "          10,\n" +
                "          10283,\n" +
                "          11,\n" +
                "          10347,\n" +
                "          12,\n" +
                "          13,\n" +
                "          14,\n" +
                "          15,\n" +
                "          10351,\n" +
                "          16,\n" +
                "          10352,\n" +
                "          10353,\n" +
                "          10362\n" +
                "        ],\n" +
                "        \"secret\": \"018c3042f35673f650c0e70f4fd4c8a6\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"com.sankuai.waimai.c.marketingprecuser\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          133,\n" +
                "          134,\n" +
                "          135,\n" +
                "          136,\n" +
                "          10,\n" +
                "          142,\n" +
                "          143,\n" +
                "          19,\n" +
                "          20,\n" +
                "          21,\n" +
                "          22,\n" +
                "          24,\n" +
                "          25,\n" +
                "          26,\n" +
                "          30,\n" +
                "          32,\n" +
                "          160,\n" +
                "          674,\n" +
                "          675,\n" +
                "          37,\n" +
                "          38,\n" +
                "          678,\n" +
                "          679,\n" +
                "          40,\n" +
                "          168,\n" +
                "          169,\n" +
                "          42,\n" +
                "          43,\n" +
                "          46,\n" +
                "          47,\n" +
                "          48,\n" +
                "          49,\n" +
                "          689,\n" +
                "          50,\n" +
                "          52,\n" +
                "          11580,\n" +
                "          708,\n" +
                "          709,\n" +
                "          70,\n" +
                "          71,\n" +
                "          201,\n" +
                "          202,\n" +
                "          203,\n" +
                "          205,\n" +
                "          206,\n" +
                "          207,\n" +
                "          719,\n" +
                "          720,\n" +
                "          721,\n" +
                "          10195,\n" +
                "          11356,\n" +
                "          10205,\n" +
                "          11357,\n" +
                "          10206,\n" +
                "          11358,\n" +
                "          11359,\n" +
                "          10207,\n" +
                "          11360,\n" +
                "          10208,\n" +
                "          10209,\n" +
                "          11361,\n" +
                "          10210,\n" +
                "          11362,\n" +
                "          11363,\n" +
                "          10211,\n" +
                "          10212,\n" +
                "          10213,\n" +
                "          10214,\n" +
                "          10215,\n" +
                "          10216,\n" +
                "          10218,\n" +
                "          10219,\n" +
                "          10220,\n" +
                "          10221,\n" +
                "          10350,\n" +
                "          10222,\n" +
                "          10223,\n" +
                "          239,\n" +
                "          10224,\n" +
                "          10225,\n" +
                "          115,\n" +
                "          116,\n" +
                "          11514,\n" +
                "          122,\n" +
                "          123\n" +
                "        ],\n" +
                "        \"secret\": \"cf75623d1fcf90fd6423914d00860666\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"test\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          10,\n" +
                "          11\n" +
                "        ],\n" +
                "        \"secret\": \"fb00bb9cb714c994d15aa6c842cea02c\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"com.sankuai.marketingcoupon.coupon.query\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          162\n" +
                "        ],\n" +
                "        \"secret\": \"fb1e26f6b2bc18e6418647ead1acf2f1\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"com.sankuai.waimai.d.hongbao\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          128,\n" +
                "          129,\n" +
                "          11521,\n" +
                "          130,\n" +
                "          131,\n" +
                "          132,\n" +
                "          10244,\n" +
                "          133,\n" +
                "          134,\n" +
                "          135,\n" +
                "          136,\n" +
                "          137,\n" +
                "          138,\n" +
                "          13,\n" +
                "          14,\n" +
                "          15,\n" +
                "          16,\n" +
                "          144,\n" +
                "          145,\n" +
                "          146,\n" +
                "          147,\n" +
                "          148,\n" +
                "          149,\n" +
                "          25,\n" +
                "          153,\n" +
                "          26,\n" +
                "          31,\n" +
                "          160,\n" +
                "          32,\n" +
                "          674,\n" +
                "          163,\n" +
                "          675,\n" +
                "          35,\n" +
                "          164,\n" +
                "          165,\n" +
                "          166,\n" +
                "          167,\n" +
                "          168,\n" +
                "          169,\n" +
                "          170,\n" +
                "          171,\n" +
                "          47,\n" +
                "          175,\n" +
                "          48,\n" +
                "          54,\n" +
                "          55,\n" +
                "          64,\n" +
                "          65,\n" +
                "          69,\n" +
                "          71,\n" +
                "          201,\n" +
                "          206,\n" +
                "          207,\n" +
                "          722,\n" +
                "          90,\n" +
                "          98,\n" +
                "          100,\n" +
                "          10342,\n" +
                "          239,\n" +
                "          240,\n" +
                "          11513,\n" +
                "          122,\n" +
                "          10363,\n" +
                "          127\n" +
                "        ],\n" +
                "        \"secret\": \"4aaa6fee0beee7835a60767097291966\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"com.sankuai.odgugc.stimulate.server\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          11425,\n" +
                "          11426,\n" +
                "          11427,\n" +
                "          11428,\n" +
                "          11429,\n" +
                "          11430,\n" +
                "          10184,\n" +
                "          10185,\n" +
                "          10186,\n" +
                "          10187,\n" +
                "          10188,\n" +
                "          10189,\n" +
                "          10190\n" +
                "        ],\n" +
                "        \"secret\": \"88ec37e64c55bd6832b9087a494116a0\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"com.sankuai.canyinrc.r.data\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          50,\n" +
                "          52,\n" +
                "          133,\n" +
                "          679,\n" +
                "          40,\n" +
                "          136\n" +
                "        ],\n" +
                "        \"secret\": \"48171a7846d2ac61b7ab75a3e7377430\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"takeaway-eventcommon-service\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          133,\n" +
                "          134,\n" +
                "          166,\n" +
                "          71,\n" +
                "          135,\n" +
                "          167,\n" +
                "          136,\n" +
                "          40,\n" +
                "          168,\n" +
                "          169,\n" +
                "          42,\n" +
                "          47,\n" +
                "          240,\n" +
                "          50,\n" +
                "          55\n" +
                "        ],\n" +
                "        \"secret\": \"640ad370f431a23ae668bc1540a75935\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"com.sankuai.waimai.d.trafficrecaller\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          209,\n" +
                "          210,\n" +
                "          10244,\n" +
                "          133,\n" +
                "          134,\n" +
                "          71,\n" +
                "          135,\n" +
                "          55,\n" +
                "          136,\n" +
                "          202,\n" +
                "          203\n" +
                "        ],\n" +
                "        \"secret\": \"bb9c5f3707e0fe26ad8fb3eb3aec4b26\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"com.sankuai.marketingactivity.promotionact\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          116\n" +
                "        ],\n" +
                "        \"secret\": \"d9d7ebe314ca96283e50e96fa028dad6\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"com.sankuai.waimai.d.hubble\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          708,\n" +
                "          709,\n" +
                "          70,\n" +
                "          71,\n" +
                "          711,\n" +
                "          135,\n" +
                "          201,\n" +
                "          10,\n" +
                "          12,\n" +
                "          14,\n" +
                "          16,\n" +
                "          211,\n" +
                "          21,\n" +
                "          22,\n" +
                "          23,\n" +
                "          28,\n" +
                "          678,\n" +
                "          679,\n" +
                "          40,\n" +
                "          168,\n" +
                "          41,\n" +
                "          106,\n" +
                "          45,\n" +
                "          115,\n" +
                "          116,\n" +
                "          54,\n" +
                "          55\n" +
                "        ],\n" +
                "        \"secret\": \"1655c361808ea683bee304fea573e9c9\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"com.sankuai.wmscene.scene\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          11521,\n" +
                "          10,\n" +
                "          11,\n" +
                "          12,\n" +
                "          13,\n" +
                "          14,\n" +
                "          15,\n" +
                "          16,\n" +
                "          17,\n" +
                "          18,\n" +
                "          19,\n" +
                "          20,\n" +
                "          21,\n" +
                "          22,\n" +
                "          23,\n" +
                "          24,\n" +
                "          25,\n" +
                "          26,\n" +
                "          27,\n" +
                "          28,\n" +
                "          29,\n" +
                "          30,\n" +
                "          31,\n" +
                "          32,\n" +
                "          33,\n" +
                "          34,\n" +
                "          35,\n" +
                "          36,\n" +
                "          37,\n" +
                "          38,\n" +
                "          39,\n" +
                "          40,\n" +
                "          10281,\n" +
                "          41,\n" +
                "          10282,\n" +
                "          42,\n" +
                "          43,\n" +
                "          10283,\n" +
                "          44,\n" +
                "          45,\n" +
                "          46,\n" +
                "          47,\n" +
                "          48,\n" +
                "          49,\n" +
                "          50,\n" +
                "          52,\n" +
                "          54,\n" +
                "          55,\n" +
                "          11580,\n" +
                "          63,\n" +
                "          64,\n" +
                "          65,\n" +
                "          66,\n" +
                "          11330,\n" +
                "          10309,\n" +
                "          11358,\n" +
                "          11359,\n" +
                "          11360,\n" +
                "          11361,\n" +
                "          11362,\n" +
                "          11364,\n" +
                "          10342,\n" +
                "          10343,\n" +
                "          104,\n" +
                "          10345,\n" +
                "          10346,\n" +
                "          10347,\n" +
                "          10348,\n" +
                "          10350,\n" +
                "          118,\n" +
                "          10362,\n" +
                "          10363,\n" +
                "          10364,\n" +
                "          124,\n" +
                "          125,\n" +
                "          126,\n" +
                "          10372,\n" +
                "          133,\n" +
                "          134,\n" +
                "          135,\n" +
                "          136,\n" +
                "          137,\n" +
                "          138,\n" +
                "          139,\n" +
                "          140,\n" +
                "          141,\n" +
                "          142,\n" +
                "          143,\n" +
                "          144,\n" +
                "          656,\n" +
                "          145,\n" +
                "          657,\n" +
                "          146,\n" +
                "          658,\n" +
                "          147,\n" +
                "          659,\n" +
                "          148,\n" +
                "          149,\n" +
                "          150,\n" +
                "          662,\n" +
                "          151,\n" +
                "          663,\n" +
                "          152,\n" +
                "          153,\n" +
                "          154,\n" +
                "          155,\n" +
                "          160,\n" +
                "          161,\n" +
                "          162,\n" +
                "          674,\n" +
                "          163,\n" +
                "          675,\n" +
                "          164,\n" +
                "          165,\n" +
                "          166,\n" +
                "          678,\n" +
                "          167,\n" +
                "          679,\n" +
                "          168,\n" +
                "          169,\n" +
                "          170,\n" +
                "          171,\n" +
                "          689,\n" +
                "          11441,\n" +
                "          703,\n" +
                "          708,\n" +
                "          709,\n" +
                "          711,\n" +
                "          713,\n" +
                "          714,\n" +
                "          205,\n" +
                "          206,\n" +
                "          719,\n" +
                "          720,\n" +
                "          721,\n" +
                "          722,\n" +
                "          10205,\n" +
                "          10206,\n" +
                "          223,\n" +
                "          10207,\n" +
                "          10208,\n" +
                "          224,\n" +
                "          10209,\n" +
                "          225,\n" +
                "          10210,\n" +
                "          226,\n" +
                "          10211,\n" +
                "          227,\n" +
                "          228,\n" +
                "          10212,\n" +
                "          229,\n" +
                "          10213,\n" +
                "          230,\n" +
                "          10214,\n" +
                "          10215,\n" +
                "          10216,\n" +
                "          10218,\n" +
                "          10219,\n" +
                "          10220,\n" +
                "          10222,\n" +
                "          239,\n" +
                "          10223,\n" +
                "          10224,\n" +
                "          10225,\n" +
                "          753,\n" +
                "          10230,\n" +
                "          10231,\n" +
                "          10232,\n" +
                "          10233,\n" +
                "          10234,\n" +
                "          11514,\n" +
                "          10235,\n" +
                "          10236\n" +
                "        ],\n" +
                "        \"secret\": \"68d781de40401b462f900be819586edd\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"com.sankuai.waimai.d.recommendreason\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          162,\n" +
                "          164,\n" +
                "          165,\n" +
                "          40,\n" +
                "          10344,\n" +
                "          10,\n" +
                "          10347,\n" +
                "          12,\n" +
                "          13,\n" +
                "          46,\n" +
                "          10351,\n" +
                "          15,\n" +
                "          10352\n" +
                "        ],\n" +
                "        \"secret\": \"8d4b38d3af2769771b880950d04da9b3\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"com.sankuai.waimai.d.merchantcoupon\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          240,\n" +
                "          210,\n" +
                "          133,\n" +
                "          134,\n" +
                "          135,\n" +
                "          136,\n" +
                "          201,\n" +
                "          206,\n" +
                "          207\n" +
                "        ],\n" +
                "        \"secret\": \"f37624d7fad1dbd744c733849d79d6cc\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"com.sankuai.waimai.service.poiflowline\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          162,\n" +
                "          168,\n" +
                "          140\n" +
                "        ],\n" +
                "        \"secret\": \"1e4555b2433e1e043dab8cd0810f8bee\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"com.sankuai.waimai.d.toolbase\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          10226,\n" +
                "          10227,\n" +
                "          10228,\n" +
                "          10229\n" +
                "        ],\n" +
                "        \"secret\": \"49ddd4c4b294be8277b70b33812c24dc\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"com.sankuai.shangou.online.smartmarketing\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          64,\n" +
                "          65,\n" +
                "          708,\n" +
                "          133,\n" +
                "          69,\n" +
                "          709,\n" +
                "          134,\n" +
                "          70,\n" +
                "          135,\n" +
                "          136,\n" +
                "          139,\n" +
                "          140,\n" +
                "          12,\n" +
                "          141,\n" +
                "          13,\n" +
                "          15,\n" +
                "          144,\n" +
                "          19,\n" +
                "          150,\n" +
                "          22,\n" +
                "          25,\n" +
                "          26,\n" +
                "          156,\n" +
                "          160,\n" +
                "          166,\n" +
                "          106,\n" +
                "          107,\n" +
                "          52,\n" +
                "          54,\n" +
                "          55,\n" +
                "          124,\n" +
                "          125,\n" +
                "          126,\n" +
                "          63\n" +
                "        ],\n" +
                "        \"secret\": \"925c2485ceb11a72fd2fa7af18562dfa\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"com.sankuai.waimai.c.marketing\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          168,\n" +
                "          719\n" +
                "        ],\n" +
                "        \"secret\": \"9a633fbd6b0a753e7712436948d35bc5\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"takeaway-lotterybase-service\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          674,\n" +
                "          675,\n" +
                "          133,\n" +
                "          134,\n" +
                "          135,\n" +
                "          136,\n" +
                "          137,\n" +
                "          138,\n" +
                "          139,\n" +
                "          140,\n" +
                "          141\n" +
                "        ],\n" +
                "        \"secret\": \"1064a5dabe4311522cd0f05f08a5b81e\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"csc-aircraft-config-web\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          663\n" +
                "        ],\n" +
                "        \"secret\": \"abdc84347d1e8ecc72ac978a3dd44f3c\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"com.sankuai.wmddatamining.theme.recall\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          10244,\n" +
                "          10,\n" +
                "          11,\n" +
                "          12,\n" +
                "          13,\n" +
                "          14,\n" +
                "          15,\n" +
                "          16,\n" +
                "          17,\n" +
                "          18,\n" +
                "          19,\n" +
                "          20,\n" +
                "          21,\n" +
                "          22,\n" +
                "          23,\n" +
                "          24,\n" +
                "          25,\n" +
                "          26,\n" +
                "          27,\n" +
                "          28,\n" +
                "          29,\n" +
                "          30,\n" +
                "          31,\n" +
                "          32,\n" +
                "          33,\n" +
                "          34,\n" +
                "          35,\n" +
                "          36,\n" +
                "          37,\n" +
                "          38,\n" +
                "          39,\n" +
                "          40,\n" +
                "          10281,\n" +
                "          41,\n" +
                "          10282,\n" +
                "          42,\n" +
                "          43,\n" +
                "          10283,\n" +
                "          44,\n" +
                "          45,\n" +
                "          46,\n" +
                "          47,\n" +
                "          48,\n" +
                "          49,\n" +
                "          50,\n" +
                "          51,\n" +
                "          52,\n" +
                "          53,\n" +
                "          54,\n" +
                "          55,\n" +
                "          63,\n" +
                "          64,\n" +
                "          65,\n" +
                "          66,\n" +
                "          11330,\n" +
                "          68,\n" +
                "          69,\n" +
                "          10309,\n" +
                "          70,\n" +
                "          71,\n" +
                "          72,\n" +
                "          10312,\n" +
                "          73,\n" +
                "          74,\n" +
                "          76,\n" +
                "          77,\n" +
                "          78,\n" +
                "          88,\n" +
                "          89,\n" +
                "          90,\n" +
                "          11356,\n" +
                "          11357,\n" +
                "          11358,\n" +
                "          11359,\n" +
                "          11360,\n" +
                "          11361,\n" +
                "          98,\n" +
                "          11362,\n" +
                "          11363,\n" +
                "          99,\n" +
                "          100,\n" +
                "          11364,\n" +
                "          101,\n" +
                "          10342,\n" +
                "          102,\n" +
                "          103,\n" +
                "          10343,\n" +
                "          104,\n" +
                "          10344,\n" +
                "          10345,\n" +
                "          10346,\n" +
                "          106,\n" +
                "          107,\n" +
                "          10347,\n" +
                "          10348,\n" +
                "          108,\n" +
                "          10349,\n" +
                "          109,\n" +
                "          110,\n" +
                "          10350,\n" +
                "          10351,\n" +
                "          111,\n" +
                "          10352,\n" +
                "          112,\n" +
                "          113,\n" +
                "          10353,\n" +
                "          114,\n" +
                "          115,\n" +
                "          116,\n" +
                "          117,\n" +
                "          118,\n" +
                "          119,\n" +
                "          121,\n" +
                "          10362,\n" +
                "          122,\n" +
                "          123,\n" +
                "          10363,\n" +
                "          10364,\n" +
                "          124,\n" +
                "          125,\n" +
                "          126,\n" +
                "          127,\n" +
                "          128,\n" +
                "          129,\n" +
                "          130,\n" +
                "          131,\n" +
                "          132,\n" +
                "          10372,\n" +
                "          133,\n" +
                "          134,\n" +
                "          135,\n" +
                "          136,\n" +
                "          137,\n" +
                "          138,\n" +
                "          139,\n" +
                "          140,\n" +
                "          141,\n" +
                "          142,\n" +
                "          143,\n" +
                "          656,\n" +
                "          144,\n" +
                "          657,\n" +
                "          145,\n" +
                "          658,\n" +
                "          146,\n" +
                "          659,\n" +
                "          147,\n" +
                "          148,\n" +
                "          149,\n" +
                "          662,\n" +
                "          150,\n" +
                "          663,\n" +
                "          151,\n" +
                "          152,\n" +
                "          153,\n" +
                "          154,\n" +
                "          155,\n" +
                "          156,\n" +
                "          157,\n" +
                "          158,\n" +
                "          159,\n" +
                "          160,\n" +
                "          673,\n" +
                "          161,\n" +
                "          674,\n" +
                "          162,\n" +
                "          675,\n" +
                "          163,\n" +
                "          676,\n" +
                "          164,\n" +
                "          677,\n" +
                "          165,\n" +
                "          678,\n" +
                "          166,\n" +
                "          679,\n" +
                "          167,\n" +
                "          168,\n" +
                "          169,\n" +
                "          170,\n" +
                "          171,\n" +
                "          175,\n" +
                "          689,\n" +
                "          11441,\n" +
                "          11442,\n" +
                "          11443,\n" +
                "          11444,\n" +
                "          11445,\n" +
                "          11446,\n" +
                "          11447,\n" +
                "          11448,\n" +
                "          11449,\n" +
                "          702,\n" +
                "          703,\n" +
                "          704,\n" +
                "          708,\n" +
                "          709,\n" +
                "          710,\n" +
                "          711,\n" +
                "          712,\n" +
                "          713,\n" +
                "          201,\n" +
                "          714,\n" +
                "          202,\n" +
                "          203,\n" +
                "          205,\n" +
                "          206,\n" +
                "          719,\n" +
                "          207,\n" +
                "          720,\n" +
                "          721,\n" +
                "          209,\n" +
                "          722,\n" +
                "          210,\n" +
                "          723,\n" +
                "          724,\n" +
                "          725,\n" +
                "          726,\n" +
                "          727,\n" +
                "          728,\n" +
                "          729,\n" +
                "          730,\n" +
                "          731,\n" +
                "          732,\n" +
                "          733,\n" +
                "          734,\n" +
                "          735,\n" +
                "          223,\n" +
                "          736,\n" +
                "          224,\n" +
                "          737,\n" +
                "          225,\n" +
                "          738,\n" +
                "          226,\n" +
                "          739,\n" +
                "          227,\n" +
                "          740,\n" +
                "          228,\n" +
                "          741,\n" +
                "          229,\n" +
                "          742,\n" +
                "          230,\n" +
                "          743,\n" +
                "          744,\n" +
                "          745,\n" +
                "          746,\n" +
                "          747,\n" +
                "          748,\n" +
                "          749,\n" +
                "          750,\n" +
                "          751,\n" +
                "          239,\n" +
                "          752,\n" +
                "          240,\n" +
                "          753,\n" +
                "          10195,\n" +
                "          10205,\n" +
                "          10206,\n" +
                "          10207,\n" +
                "          10208,\n" +
                "          10209,\n" +
                "          10210,\n" +
                "          10211,\n" +
                "          10212,\n" +
                "          10213,\n" +
                "          10214,\n" +
                "          10215,\n" +
                "          10216,\n" +
                "          10218,\n" +
                "          10219,\n" +
                "          10220,\n" +
                "          10221,\n" +
                "          10222,\n" +
                "          10223,\n" +
                "          10224,\n" +
                "          10225,\n" +
                "          10226,\n" +
                "          10227,\n" +
                "          10228,\n" +
                "          10229,\n" +
                "          10230,\n" +
                "          10231,\n" +
                "          10232,\n" +
                "          10233,\n" +
                "          10234,\n" +
                "          10235,\n" +
                "          10236\n" +
                "        ],\n" +
                "        \"secret\": \"a6efd7a7eca3ae9534b8073c628e5e29\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"com.sankuai.waimai.service.recsys\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          209,\n" +
                "          210,\n" +
                "          10244,\n" +
                "          133,\n" +
                "          134,\n" +
                "          71,\n" +
                "          135,\n" +
                "          55,\n" +
                "          136,\n" +
                "          202\n" +
                "        ],\n" +
                "        \"secret\": \"2cfaa7b4d4a2b341ec7c8e9c642cec4b\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"com.sankuai.waimai.d.search.dispatch\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          708,\n" +
                "          10372,\n" +
                "          10281,\n" +
                "          10282\n" +
                "        ],\n" +
                "        \"secret\": \"90b5e7ecb596f9974c2b6ac02ec4e7a2\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appKey\": \"quake-agent\",\n" +
                "        \"dimId\": 1,\n" +
                "        \"labelIds\": [\n" +
                "          10244,\n" +
                "          10,\n" +
                "          11,\n" +
                "          12,\n" +
                "          13,\n" +
                "          14,\n" +
                "          15,\n" +
                "          16,\n" +
                "          17,\n" +
                "          18,\n" +
                "          19,\n" +
                "          20,\n" +
                "          21,\n" +
                "          22,\n" +
                "          23,\n" +
                "          24,\n" +
                "          25,\n" +
                "          26,\n" +
                "          27,\n" +
                "          28,\n" +
                "          29,\n" +
                "          30,\n" +
                "          31,\n" +
                "          32,\n" +
                "          33,\n" +
                "          34,\n" +
                "          35,\n" +
                "          36,\n" +
                "          37,\n" +
                "          38,\n" +
                "          39,\n" +
                "          40,\n" +
                "          41,\n" +
                "          10281,\n" +
                "          42,\n" +
                "          10282,\n" +
                "          43,\n" +
                "          10283,\n" +
                "          44,\n" +
                "          45,\n" +
                "          46,\n" +
                "          47,\n" +
                "          48,\n" +
                "          49,\n" +
                "          50,\n" +
                "          51,\n" +
                "          52,\n" +
                "          53,\n" +
                "          54,\n" +
                "          55,\n" +
                "          63,\n" +
                "          64,\n" +
                "          65,\n" +
                "          66,\n" +
                "          11330,\n" +
                "          68,\n" +
                "          69,\n" +
                "          10309,\n" +
                "          70,\n" +
                "          71,\n" +
                "          72,\n" +
                "          10312,\n" +
                "          73,\n" +
                "          74,\n" +
                "          76,\n" +
                "          77,\n" +
                "          78,\n" +
                "          88,\n" +
                "          89,\n" +
                "          90,\n" +
                "          11356,\n" +
                "          11357,\n" +
                "          11358,\n" +
                "          11359,\n" +
                "          11360,\n" +
                "          11361,\n" +
                "          98,\n" +
                "          11362,\n" +
                "          99,\n" +
                "          11363,\n" +
                "          100,\n" +
                "          11364,\n" +
                "          101,\n" +
                "          102,\n" +
                "          10342,\n" +
                "          103,\n" +
                "          10343,\n" +
                "          104,\n" +
                "          10344,\n" +
                "          10345,\n" +
                "          106,\n" +
                "          10346,\n" +
                "          107,\n" +
                "          10347,\n" +
                "          108,\n" +
                "          10348,\n" +
                "          109,\n" +
                "          10349,\n" +
                "          110,\n" +
                "          10350,\n" +
                "          111,\n" +
                "          10351,\n" +
                "          112,\n" +
                "          10352,\n" +
                "          113,\n" +
                "          10353,\n" +
                "          114,\n" +
                "          115,\n" +
                "          116,\n" +
                "          117,\n" +
                "          118,\n" +
                "          119,\n" +
                "          120,\n" +
                "          121,\n" +
                "          122,\n" +
                "          10362,\n" +
                "          123,\n" +
                "          10363,\n" +
                "          124,\n" +
                "          10364,\n" +
                "          125,\n" +
                "          126,\n" +
                "          127,\n" +
                "          128,\n" +
                "          129,\n" +
                "          130,\n" +
                "          131,\n" +
                "          132,\n" +
                "          10372,\n" +
                "          133,\n" +
                "          134,\n" +
                "          135,\n" +
                "          136,\n" +
                "          137,\n" +
                "          138,\n" +
                "          139,\n" +
                "          140,\n" +
                "          141,\n" +
                "          142,\n" +
                "          143,\n" +
                "          144,\n" +
                "          656,\n" +
                "          145,\n" +
                "          657,\n" +
                "          146,\n" +
                "          658,\n" +
                "          147,\n" +
                "          659,\n" +
                "          148,\n" +
                "          149,\n" +
                "          150,\n" +
                "          662,\n" +
                "          151,\n" +
                "          663,\n" +
                "          152,\n" +
                "          664,\n" +
                "          153,\n" +
                "          154,\n" +
                "          155,\n" +
                "          156,\n" +
                "          157,\n" +
                "          158,\n" +
                "          159,\n" +
                "          160,\n" +
                "          672,\n" +
                "          161,\n" +
                "          673,\n" +
                "          11425,\n" +
                "          162,\n" +
                "          674,\n" +
                "          11426,\n" +
                "          163,\n" +
                "          675,\n" +
                "          11427,\n" +
                "          164,\n" +
                "          676,\n" +
                "          11428,\n" +
                "          165,\n" +
                "          677,\n" +
                "          11429,\n" +
                "          166,\n" +
                "          678,\n" +
                "          11430,\n" +
                "          167,\n" +
                "          679,\n" +
                "          11431,\n" +
                "          168,\n" +
                "          169,\n" +
                "          170,\n" +
                "          171,\n" +
                "          175,\n" +
                "          689,\n" +
                "          11441,\n" +
                "          11442,\n" +
                "          11443,\n" +
                "          11444,\n" +
                "          11445,\n" +
                "          11446,\n" +
                "          11447,\n" +
                "          11448,\n" +
                "          11449,\n" +
                "          702,\n" +
                "          703,\n" +
                "          704,\n" +
                "          708,\n" +
                "          709,\n" +
                "          710,\n" +
                "          711,\n" +
                "          712,\n" +
                "          201,\n" +
                "          713,\n" +
                "          202,\n" +
                "          714,\n" +
                "          203,\n" +
                "          205,\n" +
                "          206,\n" +
                "          207,\n" +
                "          719,\n" +
                "          720,\n" +
                "          209,\n" +
                "          721,\n" +
                "          210,\n" +
                "          722,\n" +
                "          723,\n" +
                "          212,\n" +
                "          724,\n" +
                "          213,\n" +
                "          725,\n" +
                "          214,\n" +
                "          726,\n" +
                "          215,\n" +
                "          727,\n" +
                "          216,\n" +
                "          728,\n" +
                "          729,\n" +
                "          730,\n" +
                "          731,\n" +
                "          732,\n" +
                "          733,\n" +
                "          734,\n" +
                "          223,\n" +
                "          735,\n" +
                "          224,\n" +
                "          736,\n" +
                "          225,\n" +
                "          737,\n" +
                "          226,\n" +
                "          738,\n" +
                "          227,\n" +
                "          739,\n" +
                "          228,\n" +
                "          740,\n" +
                "          229,\n" +
                "          741,\n" +
                "          230,\n" +
                "          742,\n" +
                "          743,\n" +
                "          744,\n" +
                "          745,\n" +
                "          746,\n" +
                "          747,\n" +
                "          748,\n" +
                "          749,\n" +
                "          750,\n" +
                "          239,\n" +
                "          751,\n" +
                "          240,\n" +
                "          752,\n" +
                "          753,\n" +
                "          11513,\n" +
                "          11514,\n" +
                "          11521,\n" +
                "          11580,\n" +
                "          10184,\n" +
                "          10185,\n" +
                "          10186,\n" +
                "          10187,\n" +
                "          10188,\n" +
                "          10189,\n" +
                "          10190,\n" +
                "          10195,\n" +
                "          10205,\n" +
                "          10206,\n" +
                "          10207,\n" +
                "          10208,\n" +
                "          10209,\n" +
                "          10210,\n" +
                "          10211,\n" +
                "          10212,\n" +
                "          10213,\n" +
                "          10214,\n" +
                "          10215,\n" +
                "          10216,\n" +
                "          10218,\n" +
                "          10219,\n" +
                "          10220,\n" +
                "          10221,\n" +
                "          10222,\n" +
                "          10223,\n" +
                "          10224,\n" +
                "          10225,\n" +
                "          10226,\n" +
                "          10227,\n" +
                "          10228,\n" +
                "          10229,\n" +
                "          10230,\n" +
                "          10231,\n" +
                "          10232,\n" +
                "          10233,\n" +
                "          10234,\n" +
                "          10235,\n" +
                "          10236\n" +
                "        ],\n" +
                "        \"secret\": \"5da5ec7f8111714328f65774a8b01426\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"updateTime\": 1615793340\n" +
                "  }\n" +
                "}";
    }
}

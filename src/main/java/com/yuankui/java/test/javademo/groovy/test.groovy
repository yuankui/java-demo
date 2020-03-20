package com.yuankui.java.test.javademo.groovy

import com.alibaba.fastjson.JSON

a = """
{
    "msg": {
        "productCount": 91,
        "userId": 251247340,
        "wmShoppingCartPoiAndProductsList": [
            {
                "wmShoppingCartPoi": {
                    "cityId": 530100,
                    "ctime": 1578993697,
                    "name": "小宅门火锅冒菜（南屏街店）",
                    "operation": "OPERATION_INSERT",
                    "picUrl": "http://p0.meituan.net/waimaipoi/a89de223ef46cb21020e1821c08515e9249721.jpg",
                    "userId": 251247340,
                    "utime": 1578993697,
                    "valid": 1,
                    "wmPoiId": 7949443
                },
                "wmShoppingCartProductMap": {
                    "2097654866": {
                        "attrIds": "",
                        "boxCount": 1,
                        "boxPrice": 0.2,
                        "checkStatus": 1,
                        "count": 1,
                        "ctime": 1578993737,
                        "discription": "",
                        "identityHashcode": 0,
                        "name": "午餐肉",
                        "operation": "OPERATION_INSERT",
                        "originalPrice": 1.2,
                        "picUrl": "http://p0.meituan.net/wmproduct/fb9120fb574cccbcb56b6bc72af0c96c1029562.png",
                        "skuId": 2097654866,
                        "userId": 251247340,
                        "utime": 1578993737,
                        "valid": 1,
                        "wmPoiId": 7949443
                    },
                    "2097518381:1789588553": {
                        "attrIds": "1789588553",
                        "boxCount": 1,
                        "boxPrice": 2.0,
                        "checkStatus": 1,
                        "count": 1,
                        "ctime": 1578993738,
                        "discription": "",
                        "identityHashcode": 0,
                        "name": "【午餐肉+时蔬】套餐（配米饭)",
                        "operation": "OPERATION_INSERT",
                        "originalPrice": 26.0,
                        "picUrl": "http://p0.meituan.net/wmproduct/391db20baff571b4400dbae1cc5f77ce2663700.png",
                        "skuId": 2097518381,
                        "userId": 251247340,
                        "utime": 1578993738,
                        "valid": 1,
                        "wmPoiId": 7949443
                    }
                }
            },
            {
                "wmShoppingCartPoi": {
                    "cityId": 530100,
                    "ctime": 1578993696,
                    "name": "胖师兄",
                    "operation": "OPERATION_INSERT",
                    "picUrl": "http://p1.meituan.net/business/725085bffe3899df7303b7f2d0d1952c92127.jpg",
                    "userId": 251247340,
                    "utime": 1578993696,
                    "valid": 1,
                    "wmPoiId": 7733997
                },
                "wmShoppingCartProductMap": {
                    "2101922758": {
                        "attrIds": "",
                        "boxCount": 1,
                        "boxPrice": 2.0,
                        "checkStatus": 1,
                        "count": 1,
                        "ctime": 1578993736,
                        "discription": "",
                        "identityHashcode": 0,
                        "name": "三鲜砂锅菜套饭",
                        "operation": "OPERATION_INSERT",
                        "originalPrice": 21.0,
                        "picUrl": "http://p1.meituan.net/wmproduct/bc510a7105e3e818a3df73d46e4acd52304978.jpg",
                        "skuId": 2101922758,
                        "userId": 251247340,
                        "utime": 1578993736,
                        "valid": 1,
                        "wmPoiId": 7733997
                    }
                }
            }
        ]
    },
    "msgType": "PRODUCT_SAVE_UPDATE",
    "userId": 251247340
}
"""

def json = JSON.parseObject(a)

1.upto(10) {
    def start = System.nanoTime()
    [json]
            .collectMany {
                if (it.msgType != 'PRODUCT_SAVE_UPDATE') {
                    return []
                }
                if (it.msg == null || it.msg.wmShoppingCartPoiAndProductsList == null) {
                    return []
                }
                return it.msg.wmShoppingCartPoiAndProductsList
            }
            .collectMany {
                return it.wmShoppingCartProductMap.values()
            }
            .each {
                [skuId: it.skuId, userId: it.userId, wmPoiId: it.wmPoiId]
            }
    
    println("cost: ${System.nanoTime() - start}")
}
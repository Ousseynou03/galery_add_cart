var stats = {
    type: "GROUP",
name: "All Requests",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "All Requests",
    "numberOfRequests": {
        "total": "2",
        "ok": "0",
        "ko": "2"
    },
    "minResponseTime": {
        "total": "156",
        "ok": "-",
        "ko": "156"
    },
    "maxResponseTime": {
        "total": "1090",
        "ok": "-",
        "ko": "1090"
    },
    "meanResponseTime": {
        "total": "623",
        "ok": "-",
        "ko": "623"
    },
    "standardDeviation": {
        "total": "467",
        "ok": "-",
        "ko": "467"
    },
    "percentiles1": {
        "total": "623",
        "ok": "-",
        "ko": "623"
    },
    "percentiles2": {
        "total": "857",
        "ok": "-",
        "ko": "857"
    },
    "percentiles3": {
        "total": "1043",
        "ok": "-",
        "ko": "1043"
    },
    "percentiles4": {
        "total": "1081",
        "ok": "-",
        "ko": "1081"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms <= t < 1200 ms",
    "htmlName": "t >= 800 ms <br> t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t >= 1200 ms",
    "htmlName": "t >= 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "htmlName": "failed",
    "count": 2,
    "percentage": 100
},
    "meanNumberOfRequestsPerSecond": {
        "total": "0.286",
        "ok": "-",
        "ko": "0.286"
    }
},
contents: {
"req_create-cart-b663b": {
        type: "REQUEST",
        name: "Create Cart",
path: "Create Cart",
pathFormatted: "req_create-cart-b663b",
stats: {
    "name": "Create Cart",
    "numberOfRequests": {
        "total": "1",
        "ok": "0",
        "ko": "1"
    },
    "minResponseTime": {
        "total": "1090",
        "ok": "-",
        "ko": "1090"
    },
    "maxResponseTime": {
        "total": "1090",
        "ok": "-",
        "ko": "1090"
    },
    "meanResponseTime": {
        "total": "1090",
        "ok": "-",
        "ko": "1090"
    },
    "standardDeviation": {
        "total": "0",
        "ok": "-",
        "ko": "0"
    },
    "percentiles1": {
        "total": "1090",
        "ok": "-",
        "ko": "1090"
    },
    "percentiles2": {
        "total": "1090",
        "ok": "-",
        "ko": "1090"
    },
    "percentiles3": {
        "total": "1090",
        "ok": "-",
        "ko": "1090"
    },
    "percentiles4": {
        "total": "1090",
        "ok": "-",
        "ko": "1090"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms <= t < 1200 ms",
    "htmlName": "t >= 800 ms <br> t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t >= 1200 ms",
    "htmlName": "t >= 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "htmlName": "failed",
    "count": 1,
    "percentage": 100
},
    "meanNumberOfRequestsPerSecond": {
        "total": "0.143",
        "ok": "-",
        "ko": "0.143"
    }
}
    },"req_get-product-tai-49049": {
        type: "REQUEST",
        name: "Get Product Taille",
path: "Get Product Taille",
pathFormatted: "req_get-product-tai-49049",
stats: {
    "name": "Get Product Taille",
    "numberOfRequests": {
        "total": "1",
        "ok": "0",
        "ko": "1"
    },
    "minResponseTime": {
        "total": "156",
        "ok": "-",
        "ko": "156"
    },
    "maxResponseTime": {
        "total": "156",
        "ok": "-",
        "ko": "156"
    },
    "meanResponseTime": {
        "total": "156",
        "ok": "-",
        "ko": "156"
    },
    "standardDeviation": {
        "total": "0",
        "ok": "-",
        "ko": "0"
    },
    "percentiles1": {
        "total": "156",
        "ok": "-",
        "ko": "156"
    },
    "percentiles2": {
        "total": "156",
        "ok": "-",
        "ko": "156"
    },
    "percentiles3": {
        "total": "156",
        "ok": "-",
        "ko": "156"
    },
    "percentiles4": {
        "total": "156",
        "ok": "-",
        "ko": "156"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms <= t < 1200 ms",
    "htmlName": "t >= 800 ms <br> t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t >= 1200 ms",
    "htmlName": "t >= 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "htmlName": "failed",
    "count": 1,
    "percentage": 100
},
    "meanNumberOfRequestsPerSecond": {
        "total": "0.143",
        "ok": "-",
        "ko": "0.143"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}

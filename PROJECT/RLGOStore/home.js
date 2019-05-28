$(function () {

    // banners用于存储从banner=1中取出的图片数据
    var banners;

    var lastedProducts;

    var pageNum = 0;

    // 独立最新商品的加载事件，将取出的response对象直接赋值给全局变量lastedProducts，方便调用
    function insertNew() {
        $(".lasted .item").remove();
        for (var i = pageNum * 4; i < pageNum * 4 + 4; i++) {
            $(".lasted").append(`
                        <div class="item">
                            <img src="${lastedProducts.data[i].imageHost}${lastedProducts.data[i].mainImage}">
                            <div class="look111" product_id="${lastedProducts.data[i].id}"></div>
                            <h1 class="title" title="${lastedProducts.data[i].name}">${lastedProducts.data[i].name}</h1>
                            <p class="desc" title="${lastedProducts.data[i].subtitle}">${lastedProducts.data[i].subtitle}</p>
                            <p class="price">￥${lastedProducts.data[i].price}</p>
                         </div>
            `)
        }
    }



    // 监听左右按钮
    $(".icon-left").click(function () {
        if (pageNum == 0) {
            pageNum = 4;
        } else {
            pageNum--;
        }
        insertNew();
    })
    $(".icon-right").click(function () {
        if (pageNum == 4) {
            pageNum = 0;
        } else {
            pageNum++;
        }
        insertNew();
    })

    // 请求第一个轮播图数据
    $.ajax({
        type: "GET",
        url: "http://www.imbession.top/portal/product/detail.do?is_banner=1",
        async: false,
        success: function (response) {
            if (response.status == 0) {
                banners = response.data;
                for (var i = 0; i < 3; i++) {
                    $("#swiper1 .swiper-wrapper").append(`<div class="swiper-slide">
                       <img src="${banners[i].imageHost}${banners[i].mainImage}"></div>`);
                    // console.log(response.data[i].imageHost+response.data[i].mainImage);
                }
                var mySwiper1 = new Swiper('#swiper1', {
                    direction: 'horizontal', // 垂直切换选项
                    loop: true, // 循环模式选项

                    // 如果需要分页器
                    pagination: {
                        el: '#swiper1 .swiper-pagination',
                        clickable: true,
                    },


                    // 如果需要前进后退按钮
                    navigation: {
                        nextEl: '#swiper1 .swiper-button-next',
                        prevEl: '#swiper1 .swiper-button-prev',
                    },

                    // 自动播放
                    autoplay: {
                        delay: 1000,
                        stopOnLastSlide: false,
                        disableOnInteraction: false,
                    },


                    // 此次练习不需要滚动图
                    // // 如果需要滚动条
                    // scrollbar: {
                    //     el: '.swiper-scrollbar',
                    // },
                })
            }
        },
        error: function () {
            alert("读取Banner1的数据时出错了");
        },
    })

    // 请求最新商品数据
    $.ajax({
        type: "GET",
        url: "http://www.imbession.top/portal/product/detail.do?is_new=1",
        async:false,
        success: function (response) {
            if (response.status == 0) {
                lastedProducts = response;
                insertNew();
            }
        },
    })

    $(".look111").click(function () {
        console.log(1);
        var id = $(this).attr("product_id");
        location.href = `http://localhost:63342/RLGOStore/detail.html?id=${id}`;
    })

    // 请求第二个轮播图数据 无需ajax请求数据，只需要从banners里拿数据就行
    for (var i = 3; i < 6; i++) {
        $("#swiper2 .swiper-wrapper").append(`<div class="swiper-slide">
                       <img src="${banners[i].imageHost}${banners[i].mainImage}"></div>`);
    }
    var mySwiper2 = new Swiper('#swiper2', {
        direction: 'horizontal', // 垂直切换选项
        loop: true, // 循环模式选项

        // 如果需要分页器
        pagination: {
            el: '#swiper2 .swiper-pagination',
            clickable: true,
        },


        // 如果需要前进后退按钮
        navigation: {
            nextEl: '#swiper2 .swiper-button-next',
            prevEl: '#swiper2 .swiper-button-prev',
        },

        // 自动播放
        autoplay: {
            delay: 1000,
            stopOnLastSlide: false,
            disableOnInteraction: false,
        },
    })

    // 请求最热商品数据
    $.ajax({
        type: "GET",
        url: "http://www.imbession.top/portal/product/detail.do?is_hot=1",
        success: function (response) {
            $(".left").append(`<img src="${response.data[1].imageHost}${response.data[1].mainImage}">`)
            $(".righttop").append(`<img src="${response.data[2].imageHost}${response.data[2].mainImage}">`)
            $(".rightbottom").append(`<img src="${response.data[0].imageHost}${response.data[0].mainImage}">`)
            $(".rightbottom").append(`<img src="${response.data[3].imageHost}${response.data[3].mainImage}">`)
        },
        error: function () {
            alert("最热商品调出错误");
        },
    })

    // banner3
    $(".banner3").append(`<img src="${banners[6].imageHost}${banners[6].mainImage}">`);

    // 电子产品展示方法
    function initElctro(id) {
        $(".electronic .item").remove();
        $.ajax({
            type: "GET",
            url: `http://www.imbession.top/portal/product/list.do?categoryId=${id}&pageNum=1&pageSize=8`,
            success: function (response) {
                if (response.status == 0) {
                    for (var i = 0; i < response.data.list.length; i++) {
                        $(".electronic").append(`<div class="item">
                                                 <img src="${response.data.list[i].imageHost}${response.data.list[i].mainImage}">
                                                 <h1 class="title" title="${response.data.list[i].name}">${response.data.list[i].name}</h1>
                                                 <p class="desc" title="${response.data.list[i].subtitle}">${response.data.list[i].subtitle}</p>
                                                 <p class="price">${response.data.list[i].price}</p>
                                                 </div>`)
                    }
                }
            },
            error: function () {
                alert("电子商品展示出错");
            },
        })
    }

    // 页面默认显示手机
    initElctro(1);

    // 监听点击文字事件
    $(".tab-item").click(function () {
        var text = $(this).text();
        if (!$(this).hasClass("active")) {
            if (text == "手机") {
                initElctro(1);
            } else if (text == "笔记本") {
                initElctro(20);
            } else if (text == "平板") {
                initElctro(39);
            }
            $(".elctronicTab .tab-item").removeClass("active");
            $(this).addClass("active");

            $(".electronicPoint .item").removeClass("active");
            var index = $(this).index();
            $(".electronicPoint .item").eq(index).addClass("active");
        }

    })

    // 监听点击底部electronicPoint事件
    $(".electronicPoint .item").click(function () {
        var index = $(this).index();
        if (!$(this).hasClass("active")) {
            if (index == 0) {
                initElctro(1);
            } else if (index == 1) {
                initElctro(20);
            } else if (index == 2) {
                initElctro(39);
            }
            $(".electronicPoint .item").removeClass("active");
            $(this).addClass("active");

            $(".tab-item").removeClass("active");
            $(".tab-item").eq(index).addClass("active");
        }
    })

    // #监听电子产品展示左右按钮
    $("#left_elec").click(function () {
        var index = $(".elctronicTab .active").index();
        console.log("当前index是" + index);
        if (index == 0) {
            initElctro(39);
            index = 2;
        } else if (index == 1) {
            initElctro(1);
            index--;
        } else if (index == 2) {
            initElctro(20);
            index--;
        }
        console.log(index);
        $(".electronicPoint .item").removeClass("active");
        $(".electronicPoint .item").eq(index).addClass("active");

        $(".tab-item").removeClass("active");
        $(".tab-item").eq(index).addClass("active");
    })

    $("#right_elec").click(function () {
        var index = $(".elctronicTab .active").index();
        console.log("当前index是" + index);
        if (index == 0) {
            initElctro(20);
            index++;
        } else if (index == 1) {
            initElctro(39);
            index++;
        } else if (index == 2) {
            initElctro(1);
            index = 0;
        }
        console.log(index);
        $(".electronicPoint .item").removeClass("active");
        $(".electronicPoint .item").eq(index).addClass("active");

        $(".tab-item").removeClass("active");
        $(".tab-item").eq(index).addClass("active");
    }),


    $("#header #header_right #header_right_top #myCount").click(function () {
        var id = $(this).attr("product_id");
        location.href = `http://localhost:63342/RLGOStore/detail.html?id=${id}`;
    })




});
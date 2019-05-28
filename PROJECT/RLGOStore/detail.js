$(function () {
    var str = location.search;
    var id = parseInt(str.substring(str.indexOf("=") + 1));
    $.ajax({
        type: "GET",
        url: `http://www.imbession.top/portal/product/detail.do?productId=${id}`,
        success:function (response) {
            if(response.status == 0) {
                $(".content").append(response.data.detail);
                $(".item").append(`<img src="${response.data.imageHost}${response.data.mainImage}">
                                    <h1 class="title" title="${response.data.name}">${response.data.name}</h1>
                                    <p class="desc" title="${response.data.subtitle}">${response.data.subtitle}</p>
                                    <p class="price">￥${response.data.price}</p>
                                 `)
                $("title").html(`${response.data.name}`);
            } else {
                alert("页面不存在");
            }

        },
        error:function () {
            alert("跳转过程错误");
        },
    })
})
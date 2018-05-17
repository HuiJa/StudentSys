<%--
  Created by IntelliJ IDEA.
  User: HuiJa
  Date: 2018/5/17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<hr>
<a onclick="pageScroll()">返回顶部</a>
<script>
    function pageScroll(){
        //把内容滚动指定的像素数（第一个参数向右滚动的像素数，第二个参数向下滚动的像素数）
        window.scrollBy(0,-100);
        //延时递归调用，模拟滚动向上效果
        scrolldelay = setTimeout('pageScroll()',100);
        //获取scrollTop值，声明了DTD的标准网页取document.documentElement.scrollTop，否则取document.body.scrollTop；因为二者只有一个会生效，另一个就恒为0，所以取和值可以得到网页的真正的scrollTop值
        var sTop=document.documentElement.scrollTop+document.body.scrollTop;
        //判断当页面到达顶部，取消延时代码（否则页面滚动到顶部会无法再向下正常浏览页面）
        if(sTop==0) clearTimeout(scrolldelay);
    }
</script>
<footer>
    <p>&copy; Company 2018</p>
</footer>

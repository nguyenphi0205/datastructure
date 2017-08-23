$(document).ready(function() {
    closeNav();
    order.init();    
});

var script = {
    orderTab: false,
    customerTab: false,
    productTab: false,
    orderTabSwich: function() {
        script.orderTab = true;
        script.customerTab = false;
        script.productTab = false;
        // script.tabSwich();
    },
    customerTabSwich: function() {
        script.orderTab = false;
        script.customerTab = true;
        script.productTab = false;
        // script.tabSwich();
    },
    productTabSwich: function() {
        script.orderTab = false;
        script.customerTab = false;
        script.productTab = true;
        // script.tabSwich();
    }
}

    function openNav() {
        document.getElementById("mySidenav").style.width = "250px";
        document.getElementById("main").style.marginLeft = "250px";
        $("#openbtn").hide();
        $("#closebtn").show();
    }

    function closeNav() {
        document.getElementById("mySidenav").style.width = "20px";
        document.getElementById("main").style.marginLeft = "20px";
        $("#closebtn").hide();
        $("#openbtn").show();
    }
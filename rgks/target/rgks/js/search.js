function checkTime() {
    var date = document.getElementsByTagName("select");
    console.log(date);
    var days = [31,28,31,30,31,30,31,31,30,31,30,31];
    var year = Number(date[0].value);
    var month = Number(date[1].value);
    var day = Number(date[2].value);
    console.log(year);
    console.log(month);
    console.log(day);
    if(days[month-1] < day){
        alert("请输入正确的日期");
        date[2].value = "01";
        return;
    }
    var today = new Date();
    console.log(today);
    var targetDay = new Date(year,month-1,day,23,59,59);
    console.log(targetDay);
    if(targetDay < today){
        alert("请勿输入非法日期");
        date[2].value = "01";
        return;
    }
}

function clearInput(item) {
    item.value = "";
}
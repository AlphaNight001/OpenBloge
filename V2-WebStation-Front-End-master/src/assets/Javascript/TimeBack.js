
let timego
let yearTime
let d;
function getDom() {
    timego = document.querySelector('.timeback');
    yearTime = document.querySelector(".year-time")
    d = new Date()
    yearTime.innerHTML = d.getFullYear() + "&nbsp;" + "年" + "&nbsp;" + (d.getMonth() + 1) + "&nbsp;" + "月" + "&nbsp;" + d.getDate() + "&nbsp;" + "日"
}

function time() {
    let date = new Date()

    let houres

    if (date.getHours() < 10) {
        houres = "0" + date.getHours()
    } else {
        houres = date.getHours()
    }


    let minute

    if (date.getMinutes() < 10) {
        minute = "0" + date.getMinutes()
    } else {
        minute = date.getMinutes()
    }

    let seconds

    if (date.getSeconds() < 10) {
        seconds = "0" + date.getSeconds()
    } else {
        seconds = date.getSeconds()
    }

    timego.innerHTML = houres + "&nbsp;" + ":" + "&nbsp;" + minute + "&nbsp;" + ":" + "&nbsp;" + seconds + "&nbsp;"
}


export { time ,getDom}










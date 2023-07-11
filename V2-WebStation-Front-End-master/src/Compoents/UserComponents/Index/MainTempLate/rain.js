var canvas = document.getElementById("canvas");
var ctx = canvas.getContext("2d");

// 设置画布宽高
canvas.width = window.innerWidth;
canvas.height = window.innerHeight;

// 雨滴对象
function Raindrop(x) {
    this.x = x;  // 横坐标为参数值
    this.y = 0;  // 纵坐标从零开始
    this.speed = 3 + Math.random() * 2;  // 雨滴速度调小
    this.length = 5 + Math.random() * 10;  // 雨滴长度
}

// 绘制雨滴
Raindrop.prototype.draw = function () {
    ctx.beginPath();
    ctx.moveTo(this.x, this.y);
    ctx.lineTo(this.x, this.y + this.length);
    ctx.strokeStyle = "#ffffff";
    ctx.lineWidth = 2;
    ctx.stroke();
};

// 更新雨滴位置
Raindrop.prototype.update = function () {
    this.y += this.speed;
    if (this.y > canvas.height) {
        this.y = 0;
    }
};

var raindrops = [];

// 计算雨滴间隔距离
var spacing = canvas.width / 100;

// 初始化雨滴
for (var i = 0; i < 100; i++) {
    raindrops.push(new Raindrop(i * spacing));
}

// 绘制并更新雨滴
function loop() {
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    for (var i = 0; i < raindrops.length; i++) {
        raindrops[i].draw();
        raindrops[i].update();
    }
    requestAnimationFrame(loop);
}

loop();
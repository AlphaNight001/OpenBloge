export function loadJS(jsUrl, callback, isCache = false) {
  var script = document.createElement('script');
  var head = document.head;
  script.type = 'text/JavaScript';
  if (isCache) {
    script.src = jsUrl + "?t=" + new Date().getTime();
  } else {
    script.src = jsUrl
  }
  if (script.addEventListener) {
    script.addEventListener('load', callback, false);
  }
  head.appendChild(script);
}

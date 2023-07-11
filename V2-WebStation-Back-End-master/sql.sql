/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80033 (8.0.33)
 Source Host           : localhost:3306
 Source Schema         : v2-webstation

 Target Server Type    : MySQL
 Target Server Version : 80033 (8.0.33)
 File Encoding         : 65001

 Date: 11/07/2023 23:00:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for artical
-- ----------------------------
DROP TABLE IF EXISTS `artical`;
CREATE TABLE `artical`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `artical_htmlTag` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `artical_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `artical_kindOf` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `artical_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `artical_lastChangeTime` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `artical_kindOfTag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `artical_markdownCode` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 76 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of artical
-- ----------------------------
INSERT INTO `artical` VALUES (66, '<h1 data-v-md-heading=\"标题一\" data-v-md-line=\"1\">标题一</h1>\n<p data-v-md-line=\"2\">下面是一个示例，展示了HTML的基本结构：</p>\n<div data-v-md-line=\"4\"><div class=\"v-md-pre-wrapper v-md-pre-wrapper-html line-numbers-mode\"><pre class=\"v-md-hljs-html\"><code><span class=\"hljs-meta\">&lt;!DOCTYPE <span class=\"hljs-meta-keyword\">html</span>&gt;</span>\n<span class=\"hljs-tag\">&lt;<span class=\"hljs-name\">html</span>&gt;</span>\n<span class=\"hljs-tag\">&lt;<span class=\"hljs-name\">head</span>&gt;</span>\n  <span class=\"hljs-tag\">&lt;<span class=\"hljs-name\">title</span>&gt;</span>网页标题<span class=\"hljs-tag\">&lt;/<span class=\"hljs-name\">title</span>&gt;</span>\n  <span class=\"hljs-tag\">&lt;<span class=\"hljs-name\">style</span>&gt;</span><span class=\"css\">\n    <span class=\"hljs-comment\">/* CSS样式可以在&lt;head&gt;标签中定义 */</span>\n    <span class=\"hljs-selector-tag\">body</span> {\n      <span class=\"hljs-attribute\">font-family</span>: Arial, sans-serif;\n      <span class=\"hljs-attribute\">background-color</span>: <span class=\"hljs-number\">#f1f1f1</span>;\n    }\n  </span><span class=\"hljs-tag\">&lt;/<span class=\"hljs-name\">style</span>&gt;</span>\n<span class=\"hljs-tag\">&lt;/<span class=\"hljs-name\">head</span>&gt;</span>\n<span class=\"hljs-tag\">&lt;<span class=\"hljs-name\">body</span>&gt;</span>\n  <span class=\"hljs-tag\">&lt;<span class=\"hljs-name\">h1</span>&gt;</span>这是一个标题<span class=\"hljs-tag\">&lt;/<span class=\"hljs-name\">h1</span>&gt;</span>\n  <span class=\"hljs-tag\">&lt;<span class=\"hljs-name\">p</span>&gt;</span>这是一个段落。<span class=\"hljs-tag\">&lt;/<span class=\"hljs-name\">p</span>&gt;</span>\n  <span class=\"hljs-tag\">&lt;<span class=\"hljs-name\">img</span> <span class=\"hljs-attr\">src</span>=<span class=\"hljs-string\">&quot;image.jpg&quot;</span> <span class=\"hljs-attr\">alt</span>=<span class=\"hljs-string\">&quot;图片描述&quot;</span>&gt;</span>\n  <span class=\"hljs-tag\">&lt;<span class=\"hljs-name\">a</span> <span class=\"hljs-attr\">href</span>=<span class=\"hljs-string\">&quot;https://www.example.com&quot;</span>&gt;</span>这是一个链接<span class=\"hljs-tag\">&lt;/<span class=\"hljs-name\">a</span>&gt;</span>\n  <span class=\"hljs-tag\">&lt;<span class=\"hljs-name\">script</span>&gt;</span><span class=\"javascript\">\n    <span class=\"hljs-comment\">// JavaScript代码可以在&lt;body&gt;标签中嵌入或外部引入</span>\n    alert(<span class=\"hljs-string\">&quot;Hello, World!&quot;</span>);\n  </span><span class=\"hljs-tag\">&lt;/<span class=\"hljs-name\">script</span>&gt;</span>\n<span class=\"hljs-tag\">&lt;/<span class=\"hljs-name\">body</span>&gt;</span>\n<span class=\"hljs-tag\">&lt;/<span class=\"hljs-name\">html</span>&gt;</span>\n</code></pre>\n<div class=\"line-numbers-wrapper\"><span class=\"line-number\">1</span><br><span class=\"line-number\">2</span><br><span class=\"line-number\">3</span><br><span class=\"line-number\">4</span><br><span class=\"line-number\">5</span><br><span class=\"line-number\">6</span><br><span class=\"line-number\">7</span><br><span class=\"line-number\">8</span><br><span class=\"line-number\">9</span><br><span class=\"line-number\">10</span><br><span class=\"line-number\">11</span><br><span class=\"line-number\">12</span><br><span class=\"line-number\">13</span><br><span class=\"line-number\">14</span><br><span class=\"line-number\">15</span><br><span class=\"line-number\">16</span><br><span class=\"line-number\">17</span><br><span class=\"line-number\">18</span><br><span class=\"line-number\">19</span><br><span class=\"line-number\">20</span><br><span class=\"line-number\">21</span><br><span class=\"line-number\">22</span><br><span class=\"line-number\">23</span><br></div></div></div><p data-v-md-line=\"31\">在上述示例中，<code>&lt;!DOCTYPE html&gt;</code>定义了文档类型为HTML。<code>&lt;html&gt;</code>标签是HTML文档的根元素，包含了整个网页的内容。<code>&lt;head&gt;</code>标签用于定义文档的元信息，如标题和样式表。<code>&lt;body&gt;</code>标签包含了实际的网页内容，如标题、段落、图像、链接和脚本等。</p>\n<p data-v-md-line=\"33\">注意：上述示例中的CSS样式和JavaScript代码只是简单的示范，并不代表HTML、CSS和JavaScript的全部功能和用法。<br>\n在上述示例中，<code>&lt;!DOCTYPE html&gt;</code>定义了文档类型为HTML。<code>&lt;html&gt;</code>标签是HTML文档的根元素，包含了整个网页的内容。<code>&lt;head&gt;</code>标签用于定义文档的元信息，如标题和样式表。<code>&lt;body&gt;</code>标签包含了实际的网页内容，如标题、段落、图像、链接和脚本等。</p>\n<p data-v-md-line=\"36\">注意：上述示例中的CSS样式和JavaScript代码只是简单的示范，并不代表HTML、CSS和JavaScript的全部功能和用法。<br>\n在上述示例中，<code>&lt;!DOCTYPE html&gt;</code>定义了文档类型为HTML。<code>&lt;html&gt;</code>标签是HTML文档的根元素，包含了整个网页的内容。<code>&lt;head&gt;</code>标签用于定义文档的元信息，如标题和样式表。<code>&lt;body&gt;</code>标签包含了实际的网页内容，如标题、段落、图像、链接和脚本等。</p>\n<h1 data-v-md-heading=\"标题2\" data-v-md-line=\"38\">标题2</h1>\n<p data-v-md-line=\"39\">注意：上述示例中的CSS样式和JavaScript代码只是简单的示范，并不代表HTML、CSS和JavaScript的全部功能和用法。<br>\n在上述示例中，<code>&lt;!DOCTYPE html&gt;</code>定义了文档类型为HTML。<code>&lt;html&gt;</code>标签是HTML文档的根元素，包含了整个网页的内容。<code>&lt;head&gt;</code>标签用于定义文档的元信息，如标题和样式表。<code>&lt;body&gt;</code>标签包含了实际的网页内容，如标题、段落、图像、链接和脚本等。</p>\n<p data-v-md-line=\"42\">注意：上述示例中的CSS样式和JavaScript代码只是简单的示范，并不代表HTML、CSS和JavaScript的全部功能和用法。<br>\n在上述示例中，<code>&lt;!DOCTYPE html&gt;</code>定义了文档类型为HTML。<code>&lt;html&gt;</code>标签是HTML文档的根元素，包含了整个网页的内容。<code>&lt;head&gt;</code>标签用于定义文档的元信息，如标题和样式表。<code>&lt;body&gt;</code>标签包含了实际的网页内容，如标题、段落、图像、链接和脚本等。</p>\n<p data-v-md-line=\"45\">注意：上述示例中的CSS样式和JavaScript代码只是简单的示范，并不代表HTML、CSS和JavaScript的全部功能和用法。<br>\n在上述示例中，<code>&lt;!DOCTYPE html&gt;</code>定义了文档类型为HTML。<code>&lt;html&gt;</code>标签是HTML文档的根元素，包含了整个网页的内容。<code>&lt;head&gt;</code>标签用于定义文档的元信息，如标题和样式表。<code>&lt;body&gt;</code>标签包含了实际的网页内容，如标题、段落、图像、链接和脚本等。</p>\n<p data-v-md-line=\"48\">注意：上述示例中的CSS样式和JavaScript代码只是简单的示范，并不代表HTML、CSS和JavaScript的全部功能和用法。<br>\n在上述示例中，<code>&lt;!DOCTYPE html&gt;</code>定义了文档类型为HTML。<code>&lt;html&gt;</code>标签是HTML文档的根元素，包含了整个网页的内容。<code>&lt;head&gt;</code>标签用于定义文档的元信息，如标题和样式表。<code>&lt;body&gt;</code>标签包含了实际的网页内容，如标题、段落、图像、链接和脚本等。</p>\n<h1 data-v-md-heading=\"标题3\" data-v-md-line=\"50\">标题3</h1>\n<p data-v-md-line=\"51\">注意：上述示例中的CSS样式和JavaScript代码只是简单的示范，并不代表HTML、CSS和JavaScript的全部功能和用法。<br>\n在上述示例中，<code>&lt;!DOCTYPE html&gt;</code>定义了文档类型为HTML。<code>&lt;html&gt;</code>标签是HTML文档的根元素，包含了整个网页的内容。<code>&lt;head&gt;</code>标签用于定义文档的元信息，如标题和样式表。<code>&lt;body&gt;</code>标签包含了实际的网页内容，如标题、段落、图像、链接和脚本等。</p>\n<p data-v-md-line=\"54\">注意：上述示例中的CSS样式和JavaScript代码只是简单的示范，并不代表HTML、CSS和JavaScript的全部功能和用法。</p>\n', 'HTML是什么', '前端', '2023-05-24', '2023-05-27', 'HTML', '# 标题一\n下面是一个示例，展示了HTML的基本结构：\n\n```html\n<!DOCTYPE html>\n<html>\n<head>\n  <title>网页标题</title>\n  <style>\n    /* CSS样式可以在<head>标签中定义 */\n    body {\n      font-family: Arial, sans-serif;\n      background-color: #f1f1f1;\n    }\n  </style>\n</head>\n<body>\n  <h1>这是一个标题</h1>\n  <p>这是一个段落。</p>\n  <img src=\"image.jpg\" alt=\"图片描述\">\n  <a href=\"https://www.example.com\">这是一个链接</a>\n  <script>\n    // JavaScript代码可以在<body>标签中嵌入或外部引入\n    alert(\"Hello, World!\");\n  </script>\n</body>\n</html>\n```\n\n\n在上述示例中，`<!DOCTYPE html>`定义了文档类型为HTML。`<html>`标签是HTML文档的根元素，包含了整个网页的内容。`<head>`标签用于定义文档的元信息，如标题和样式表。`<body>`标签包含了实际的网页内容，如标题、段落、图像、链接和脚本等。\n\n注意：上述示例中的CSS样式和JavaScript代码只是简单的示范，并不代表HTML、CSS和JavaScript的全部功能和用法。\n在上述示例中，`<!DOCTYPE html>`定义了文档类型为HTML。`<html>`标签是HTML文档的根元素，包含了整个网页的内容。`<head>`标签用于定义文档的元信息，如标题和样式表。`<body>`标签包含了实际的网页内容，如标题、段落、图像、链接和脚本等。\n\n注意：上述示例中的CSS样式和JavaScript代码只是简单的示范，并不代表HTML、CSS和JavaScript的全部功能和用法。\n在上述示例中，`<!DOCTYPE html>`定义了文档类型为HTML。`<html>`标签是HTML文档的根元素，包含了整个网页的内容。`<head>`标签用于定义文档的元信息，如标题和样式表。`<body>`标签包含了实际的网页内容，如标题、段落、图像、链接和脚本等。\n# 标题2\n注意：上述示例中的CSS样式和JavaScript代码只是简单的示范，并不代表HTML、CSS和JavaScript的全部功能和用法。\n在上述示例中，`<!DOCTYPE html>`定义了文档类型为HTML。`<html>`标签是HTML文档的根元素，包含了整个网页的内容。`<head>`标签用于定义文档的元信息，如标题和样式表。`<body>`标签包含了实际的网页内容，如标题、段落、图像、链接和脚本等。\n\n注意：上述示例中的CSS样式和JavaScript代码只是简单的示范，并不代表HTML、CSS和JavaScript的全部功能和用法。\n在上述示例中，`<!DOCTYPE html>`定义了文档类型为HTML。`<html>`标签是HTML文档的根元素，包含了整个网页的内容。`<head>`标签用于定义文档的元信息，如标题和样式表。`<body>`标签包含了实际的网页内容，如标题、段落、图像、链接和脚本等。\n\n注意：上述示例中的CSS样式和JavaScript代码只是简单的示范，并不代表HTML、CSS和JavaScript的全部功能和用法。\n在上述示例中，`<!DOCTYPE html>`定义了文档类型为HTML。`<html>`标签是HTML文档的根元素，包含了整个网页的内容。`<head>`标签用于定义文档的元信息，如标题和样式表。`<body>`标签包含了实际的网页内容，如标题、段落、图像、链接和脚本等。\n\n注意：上述示例中的CSS样式和JavaScript代码只是简单的示范，并不代表HTML、CSS和JavaScript的全部功能和用法。\n在上述示例中，`<!DOCTYPE html>`定义了文档类型为HTML。`<html>`标签是HTML文档的根元素，包含了整个网页的内容。`<head>`标签用于定义文档的元信息，如标题和样式表。`<body>`标签包含了实际的网页内容，如标题、段落、图像、链接和脚本等。\n# 标题3\n注意：上述示例中的CSS样式和JavaScript代码只是简单的示范，并不代表HTML、CSS和JavaScript的全部功能和用法。\n在上述示例中，`<!DOCTYPE html>`定义了文档类型为HTML。`<html>`标签是HTML文档的根元素，包含了整个网页的内容。`<head>`标签用于定义文档的元信息，如标题和样式表。`<body>`标签包含了实际的网页内容，如标题、段落、图像、链接和脚本等。\n\n注意：上述示例中的CSS样式和JavaScript代码只是简单的示范，并不代表HTML、CSS和JavaScript的全部功能和用法。');
INSERT INTO `artical` VALUES (68, '<p data-v-md-line=\"1\">瓦打我打我的爱我的a</p>\n<div data-v-md-line=\"5\"><div class=\"v-md-pre-wrapper v-md-pre-wrapper-html line-numbers-mode\"><pre class=\"v-md-hljs-html\"><code>\n<span class=\"hljs-tag\">&lt;<span class=\"hljs-name\">a</span>&gt;</span>test<span class=\"hljs-tag\">&lt;/<span class=\"hljs-name\">a</span>&gt;</span>\n\n<span class=\"hljs-tag\">&lt;<span class=\"hljs-name\">a</span>&gt;</span>test<span class=\"hljs-tag\">&lt;/<span class=\"hljs-name\">a</span>&gt;</span>\n</code></pre>\n<div class=\"line-numbers-wrapper\"><span class=\"line-number\">1</span><br><span class=\"line-number\">2</span><br><span class=\"line-number\">3</span><br><span class=\"line-number\">4</span><br></div></div></div>', '论文答辩', '开发工具', '2023-05-25', '2023-05-25', '论文', '瓦打我打我的爱我的a\n\n\n\n``` html\n\n<a>test</a>\n\n<a>test</a>\n```');
INSERT INTO `artical` VALUES (69, '<p data-v-md-line=\"2\">第一章 绪论</p>\n<h2 data-v-md-heading=\"_1-1-研究背景\" data-v-md-line=\"3\">1.1 研究背景</h2>\n<p data-v-md-line=\"4\">个人学习内容分享网站的出现是对现代教育和学习环境的需求的回应。随着互联网的迅速发展和普及，人们对学习和知识获取的方式发生了重大变化。传统的学习模式逐渐受到挑战，学习者希望更加灵活、自主地获取知识，并与其他学习者进行交流和互动。</p>\n<p data-v-md-line=\"6\">个人学习内容分享网站的兴起源于以下几个方面的研究背景：</p>\n<ol data-v-md-line=\"8\">\n<li>\n<p data-v-md-line=\"8\">学习者自主性：个人学习内容分享网站鼓励学习者主动参与知识的创建和分享过程。它提供了一个平台，让学习者可以自由地发布自己的学习经验、观点和知识，从而促进自主学习和个人成长。</p>\n</li>\n<li>\n<p data-v-md-line=\"10\">社交学习和协作：研究表明，与他人互动和分享学习经验可以增强学习效果。个人学习内容分享网站提供了一个社交化的学习环境，学习者可以在平台上与其他学习者进行交流、讨论和合作，共同构建知识共同体。</p>\n</li>\n<li>\n<p data-v-md-line=\"12\">多样性的学习资源：传统学习资源的限制和有限性成为学习者的挑战。个人学习内容分享网站通过吸引来自不同背景和领域的学习者，为用户提供了多样性的学习资源和观点。这种多样性可以激发创新思维、跨学科学习和多元化视角。</p>\n</li>\n<li>\n<p data-v-md-line=\"14\">个性化学习：每个学习者都有不同的学习偏好和需求。个人学习内容分享网站可以根据学习者的兴趣、能力和目标提供个性化的学习内容和建议，帮助他们更好地实现学习目标。</p>\n</li>\n</ol>\n<p data-v-md-line=\"16\">综上所述，个人学习内容分享网站的研究背景包括学习者的自主性、社交学习和协作、多样性的学习资源以及个性化学习的需求。这些背景推动了对这类网站的研究和开发，旨在为学习者提供一个互动、多样化和个性化的学</p>\n', '即将发布的文章', '前端', '2023-05-25', '2023-05-25', 'Html', '\n第一章 绪论\n## 1.1 研究背景\n个人学习内容分享网站的出现是对现代教育和学习环境的需求的回应。随着互联网的迅速发展和普及，人们对学习和知识获取的方式发生了重大变化。传统的学习模式逐渐受到挑战，学习者希望更加灵活、自主地获取知识，并与其他学习者进行交流和互动。\n\n个人学习内容分享网站的兴起源于以下几个方面的研究背景：\n\n1. 学习者自主性：个人学习内容分享网站鼓励学习者主动参与知识的创建和分享过程。它提供了一个平台，让学习者可以自由地发布自己的学习经验、观点和知识，从而促进自主学习和个人成长。\n\n2. 社交学习和协作：研究表明，与他人互动和分享学习经验可以增强学习效果。个人学习内容分享网站提供了一个社交化的学习环境，学习者可以在平台上与其他学习者进行交流、讨论和合作，共同构建知识共同体。\n\n3. 多样性的学习资源：传统学习资源的限制和有限性成为学习者的挑战。个人学习内容分享网站通过吸引来自不同背景和领域的学习者，为用户提供了多样性的学习资源和观点。这种多样性可以激发创新思维、跨学科学习和多元化视角。\n\n4. 个性化学习：每个学习者都有不同的学习偏好和需求。个人学习内容分享网站可以根据学习者的兴趣、能力和目标提供个性化的学习内容和建议，帮助他们更好地实现学习目标。\n\n综上所述，个人学习内容分享网站的研究背景包括学习者的自主性、社交学习和协作、多样性的学习资源以及个性化学习的需求。这些背景推动了对这类网站的研究和开发，旨在为学习者提供一个互动、多样化和个性化的学');
INSERT INTO `artical` VALUES (71, '<p data-v-md-line=\"1\">awadawd</p>\n', '测试文章4', '操作系统', '2023-05-27', '2023-05-27', 'test', 'awadawd');
INSERT INTO `artical` VALUES (72, '<p data-v-md-line=\"1\">阿瓦达瓦大</p>\n', '测试文章5', '开发工具', '2023-05-27', '2023-05-27', 'test', '阿瓦达瓦大');
INSERT INTO `artical` VALUES (73, '<p data-v-md-line=\"1\">阿瓦打我</p>\n', '测试文章6', '移动端应用', '2023-05-27', '2023-05-27', 'test', '阿瓦打我');
INSERT INTO `artical` VALUES (74, '<h1 data-v-md-heading=\"test\" data-v-md-line=\"1\">test</h1>\n<p data-v-md-line=\"3\">awww</p>\n', 'awdwd', '后端', '2023-05-27', '2023-05-27', 'waw', '# test\n\nawww');
INSERT INTO `artical` VALUES (75, '<h1 data-v-md-heading=\"hello哦\" data-v-md-line=\"1\">Hello哦</h1>\n<p data-v-md-line=\"2\">efwf<br>\nwef<br>\new<br>\nfew<br>\nf<br>\nwe<br>\nfew</p>\n', '711', '前端', '2023-07-11', '2023-07-11', 'test', '# Hello哦\nefwf\nwef\new\nfew\nf\nwe\nfew\n\n\n');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `msg_userid` int NOT NULL,
  `msg_username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `msg_message` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `msg_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (10, 7, 'Alpha', '大家好，我来测试一下', '2023-05-04 22:41:14');
INSERT INTO `message` VALUES (14, 7, 'Alpha', 'test', '2023-05-27 11:15:45');
INSERT INTO `message` VALUES (15, 7, 'Alpha', 'wadawd', '2023-07-11 00:13:00');

-- ----------------------------
-- Table structure for updatego
-- ----------------------------
DROP TABLE IF EXISTS `updatego`;
CREATE TABLE `updatego`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `html_Tag` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `update_Time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `markdown_Code` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 53 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of updatego
-- ----------------------------
INSERT INTO `updatego` VALUES (50, '<h1 data-v-md-heading=\"更新日志\" data-v-md-line=\"1\">更新日志</h1>\n<p data-v-md-line=\"2\">本次毕业设计已经完成，更新日志的测试！！</p>\n', '2023-05-25', '# 更新日志\n本次毕业设计已经完成，更新日志的测试！！');
INSERT INTO `updatego` VALUES (51, '<p data-v-md-line=\"1\">公告</p>\n<p data-v-md-line=\"4\">网站即将更新!!!</p>\n', '2023-05-25', '公告\n\n\n网站即将更新!!!');
INSERT INTO `updatego` VALUES (52, '<p data-v-md-line=\"1\">da</p>\n', '2023-05-27', 'da');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_power` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_token` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `user_ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_isban` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_lastip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (8, 'aef', '123123', '0', NULL, '127.0.0.1', '1643992522@qq.com', '0', '127.0.0.1');
INSERT INTO `user` VALUES (9, 'test', '123123', '0', NULL, '127.0.0.1', '1643992522@qq.com', '0', NULL);
INSERT INTO `user` VALUES (10, 'aef0', '123123', '0', NULL, '127.0.0.1', '1643992522@qq.com', '0', '127.0.0.1');

SET FOREIGN_KEY_CHECKS = 1;

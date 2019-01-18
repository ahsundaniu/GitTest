<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>jQuery UI 对话框（Dialog） - 默认功能</title>
  <link rel="stylesheet" href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
  <script src="//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
  <script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
  <link rel="stylesheet" href="jqueryui/style.css">
  <script>
  $(function() {
	    $( "#dialog-modal" ).dialog({
	      height:540,width:600,
	      modal: true
	    });
	  });
  </script>
</head>
<body>
 
<div id="dialog-modal" title="基本的模态对话框">
  <p>添加模态覆盖屏幕，让对话框看起来更突出，因为它让页面上其他内容变暗。</p>
</div>
  <p>这是一个默认的对话框，用于显示信息。对话框窗口可以移动，调整尺寸，默认可通过 'x' 图标关闭。</p>
</div>
 
 
</body>
</html>
<html>
	<head>
		<title>PHP Example</title>
		<link rel="stylesheet" href="../style.css" />
	</head>
	<body>
		{include file='header.tpl'}
		<div class="content">
			{include file='user/listTable.tpl'}
		</div>
		<div class="commands">
			<a class="button" href="{$createAction}">create new user</a>
		</div>
		{include file='footer.tpl'}
	</body>
</html>

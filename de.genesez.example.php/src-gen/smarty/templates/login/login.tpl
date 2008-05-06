<html>
	<head>
		<title>PHP Example Login</title>
		<link rel="stylesheet" href="../style.css" />
	</head>
	<body>
		{include file='header.tpl'}
		<form {$form.attributes}>
			<div class="content">
				{* output the quickform login form *}
				{$form.javascript}
					{$form.hidden}
					<table class="userEdit">
						<tr><td>{$form.username.label}:</td><td>{$form.username.html}</td></tr>
						<tr><td>{$form.password.label}:</td><td>{$form.password.html}</td></tr>
					</table>
			</div>
			<div class="commands">
				{$form.login.html}
			</div>
		</form>
		{include file='footer.tpl'}
	</body>
</html>

<html>
	<head>
		<title>PHP Example</title>
		<link rel="stylesheet" href="../style.css" />
	</head>
	<body>
		{include file='header.tpl'}
		<form {$form.attributes}>
			<div class="content">
				{* output the quickform form *}
				{$form.javascript}
					{$form.hidden}
					<table class="userEdit">
						<tr><td>{$form.login.label}:</td><td>{$form.login.html}</td></tr>
						<tr><td>{$form.password.label}:</td><td>{$form.password.html}</td></tr>
						<tr><td>{$form.passwordRepeat.label}:</td><td>{$form.passwordRepeat.html}</td></tr>
						<tr><td>{$form.firstName.label}:</td><td>{$form.firstName.html}</td></tr>
						<tr><td>{$form.lastName.label}:</td><td>{$form.lastName.html}</td></tr>
						<tr><td>{$form.email.label}:</td><td>{$form.email.html}</td></tr>
					</table>
			</div>
			<div class="commands">
				{$form.save.html}
			</div>
		</form>
		{include file='footer.tpl'}
	</body>
</html>

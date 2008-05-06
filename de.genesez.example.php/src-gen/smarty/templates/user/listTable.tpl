
<table>
	<tr>
		<th>login</th>
		<th>firstName</th>
		<th>lastName</th>
		<th>email</th>
		{* PROTECTED REGION ID(php.smarty.listview.header._14_0_b6f02e1_1206538020843_168097_254) ENABLED START *}
		{* TODO: put your further table header columns here *}
		<th>actions</th>
		{* PROTECTED REGION END *}
	</tr>
	{foreach from=$users item="user"}
	<tr>
		<td>{$user.login}</td>
		<td>{$user.firstName}</td>
		<td>{$user.lastName}</td>
		<td>{$user.email}</td>
		{* PROTECTED REGION ID(php.smarty.listview.body._14_0_b6f02e1_1206538020843_168097_254) ENABLED START *}
		{* TODO: put your further table body columns here *}
		<td><a href="{$editAction}?id={$user.id}">edit</a>, <a href="{$deleteAction}?id={$user.id}">delete</a></td>
		{* PROTECTED REGION END *}
	</tr>
	{/foreach}
</table>

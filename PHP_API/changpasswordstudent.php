<?php
    require "dbCon.php";
	if(isset($_POST['i_student']) && isset($_POST['oldpass']) && isset($_POST['password']))
	{	
		$i_student= $_POST['i_student'];
		$oldpass = $_POST['oldpass'];
		$password = $_POST['password'];

		$query2 = (String)"SELECT password from tb_user where i_student = $i_student";
		$checkpass = mysqli_query($connect, $query2);
		while ($row = mysqli_fetch_assoc($checkpass))
		{
			$passwordcu = $row['password'];
		}
		if($oldpass == $passwordcu)
		{
			$query = "UPDATE tb_user tbu SET tbu.oldpass = $oldpass, tbu.password = $password WHERE tbu.i_student = $i_student and tbu.password = $oldpass";
			$data = mysqli_query($connect, $query);
			echo "Done";
		}
		else
		{
			echo "Fail";
		}
		
	};
?>
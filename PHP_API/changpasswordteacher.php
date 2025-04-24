<?php
    require "dbCon.php";
	if(isset($_POST['i_teacher']) && isset($_POST['oldpass']) && isset($_POST['password']))
	{	
		$i_teacher= $_POST['i_teacher'];
		$oldpass = $_POST['oldpass'];
		$password = $_POST['password'];

		$query2 = (String)"SELECT password from tb_user where i_teacher = $i_teacher";
		$checkpass = mysqli_query($connect, $query2);
		while ($row = mysqli_fetch_assoc($checkpass)) {
			$passwordcu = $row['password'];
		}

		if($oldpass == $passwordcu) {
			$query = "UPDATE tb_user tbu SET tbu.oldpass = $oldpass, tbu.password = $password WHERE tbu.i_teacher = $i_teacher and tbu.password = $oldpass";
			$data = mysqli_query($connect, $query);
			echo "Done";
		} else {
			echo "Fail";
		}
	}
?>
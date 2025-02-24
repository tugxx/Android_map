<?php
	require "dbCon.php";
	$teacher_id = $_POST['teacher_id'];
    $query = "SELECT * from class  WHERE teacher_id='$teacher_id'";

	$data = mysqli_query($connect, $query);

    //Tao lớp 
    class classS{
		function __construct($class_id, $class_name){
			$this->id = $class_id;
			$this->name = $class_name;

		}
	}
    //2.Tao mang 
    $mangSV = array();
    //3. Them phan tu vao mang
    while($row = mysqli_fetch_assoc($data)){
       array_push($mangSV, new classS($row['class_id'],$row['class_name']));
    }

    //4.Chuyen dinh dang cua mang -->Json
    echo json_encode($mangSV);
//
?>
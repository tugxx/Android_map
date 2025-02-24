<?php
	require "dbCon.php";
	if(isset($_POST['student_id']))
	{	
	$student_id = $_POST['student_id'];
    // Get Class_id for student_id
	$query1 = "SELECT class_id FROM student_class WHERE student_id='$student_id'";
	$data_class_id = mysqli_query($connect, $query1);
    while ($row = mysqli_fetch_assoc($data_class_id)){
        $array_class_id [] = $row['class_id'];
    }
    //Get Class_name for Class_id (data_class_id)
    $listclassforstudent = new ArrayObject();
    foreach($array_class_id as $key => $value)
    {
        $query2 = "SELECT class_id, class_name FROM class WHERE class_id ='$value'"; //value = class_id in array
	    $data_class = mysqli_query($connect, $query2);
        while ($row = mysqli_fetch_assoc($data_class)) {
            $class = new dbclass_present($row['class_id'], $row['class_name']);
            $listclassforstudent [] = $class;
        }
    }
	// echo data API
	if(!empty($array_class_id)){
		foreach( $listclassforstudent as $key => $value ){
			$obj_json[] = $value;
		}
		echo json_encode($obj_json);
	}else{
		echo "Error";
	};
	}
?>


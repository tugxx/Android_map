<?php
    $file_path = "Upload\student_images";
    $file_path = $file_path.basename($_FILES['upload_file']['name']);

    if (move_uploaded_file($_FILES['upload_file']['tmp_name'],$file_path)) {
        // error_log("Yes");
        echo $_FILES['upload_file']['name'];
    } else {
        // error_log("failed");
        echo "Failed";
    } 
?>
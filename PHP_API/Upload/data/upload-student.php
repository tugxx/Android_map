<?php
    $uploadDir = __DIR__ . '/student/';
    if (!is_dir($uploadDir)) {
        mkdir($uploadDir, 0755, true);
    }

    if (isset($_FILES['file'])) {
        $file = $_FILES['file'];
        if ($file['error'] === UPLOAD_ERR_OK) {
            $fileName = basename($file['name']);
            $targetPath = $uploadDir . $fileName;
            if (move_uploaded_file($file['tmp_name'], $targetPath)) {
                http_response_code(200);
                echo 'File uploaded successfully';
            } else {
                http_response_code(500);
                echo 'Failed to save file';
            }
        } else {
            http_response_code(400);
            echo 'File upload error';
        }
    } else {
        http_response_code(400);
        echo 'No file provided';
    }
?>
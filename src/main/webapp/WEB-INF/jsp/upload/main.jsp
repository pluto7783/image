<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Upload test</title>
</head>
<body>
    <main>
        <h1>Upload test</h1>
        <select id="jobType" aria-label="Document type">
            <option value="A0101">A0101</option>
            <option value="A0102">A0102</option>
            <option value="A0103">A0103</option>
            <option value="A0104">A0104</option>
            <option value="A0201">A0201</option>
            <option value="A0301">A0301</option>
        </select>
        <button id="uploadButton" type="button">Send JSON POST</button>
        <pre id="result" aria-live="polite"></pre>
    </main>

    <script>
        document.getElementById('uploadButton').addEventListener('click', async () => {
            const result = document.getElementById('result');
            const jobType = document.getElementById('jobType').value;
            result.textContent = 'Sending request...';

            try {
                const response = await fetch('${pageContext.request.contextPath}/uploads/uploadJsonToWas', {
                    method: 'POST',
                    headers: { 'Content-Type': 'application/json' },
                    body: JSON.stringify({
                        jobType: jobType,
                        content: 'Sample data from JSP'
                    })
                });

                const responseBody = await response.json();
                result.textContent = JSON.stringify(responseBody, null, 2);
            } catch (error) {
                result.textContent = `Request failed: ${error.message}`;
            }
        });
    </script>
</body>
</html>

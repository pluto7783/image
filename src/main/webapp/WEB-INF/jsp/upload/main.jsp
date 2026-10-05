<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>업로드 테스트</title>
</head>
<body>
    <main>
        <h1>업로드 테스트</h1>
        <button id="uploadButton" type="button">JSON POST 요청 보내기</button>
        <pre id="result" aria-live="polite"></pre>
    </main>

    <script>
        document.getElementById('uploadButton').addEventListener('click', async () => {
            const result = document.getElementById('result');
            result.textContent = '요청 중...';

            try {
                const response = await fetch('${pageContext.request.contextPath}/uploads/uploadJsonToWas', {
                    method: 'POST',
                    headers: { 'Content-Type': 'application/json' },
                    body: JSON.stringify({
                        jobType: 'SAMPLE',
                        content: 'JSP에서 보낸 샘플 데이터12'
                    })
                });

                const responseBody = await response.json();
                result.textContent = JSON.stringify(responseBody, null, 2);
            } catch (error) {
                result.textContent = `요청 실패: ${error.message}`;
            }
        });
    </script>
</body>
</html>

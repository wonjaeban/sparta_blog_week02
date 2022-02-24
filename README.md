# sparta_blog_week02
게시판을 작성할 수 있는 간단한 블로그입니다. 프론트단은 전혀 신경쓰지 않았으며 spring을 활용한 서버와 API 구축 등 기능구현에만 신경썼습니다.

### Main Page
![image](https://user-images.githubusercontent.com/70055619/155487803-457a8510-54ab-48dc-861e-d8e20a6cd50a.png)


### LookUp Page (게시글 상세페이지)
![image](https://user-images.githubusercontent.com/70055619/155487987-6b59f6c7-076d-4a4e-ad5e-855852f8b190.png)


아래에 댓글도 있습니다. 로그인하지 않거나 해당 댓글의 본인이 아니면 댓글 수정 및 삭제는 불가합니다. 댓글 및 게시글 작성도 로그인 하지 않으면 불가합니다.

![image](https://user-images.githubusercontent.com/70055619/155488258-98dcc0f3-13aa-45ee-8c82-6f5513855a4f.png)



### Upload Page
![image](https://user-images.githubusercontent.com/70055619/155488741-b8421a5a-a92e-4037-b6fd-4d02e47cb111.png)



### SignUp page
![image](https://user-images.githubusercontent.com/70055619/155488868-ea9ac886-229d-4317-8dca-77759a51e0b1.png)


### Login page
![image](https://user-images.githubusercontent.com/70055619/155488943-1acc35c1-468c-4b39-8269-51a107d5e7a2.png)

### Login page(카카오 소셜 로그인API)
![image](https://user-images.githubusercontent.com/70055619/155492455-9b3eaca4-5b16-4bf0-831a-2d63e74f0aba.png)



## 주요 API 설계

| 기능          | URL             | Method    |Request      |Response|
| ----------- | --------------- | --------- | ----------- | ------ |
| 게시글 작성하기     | /api/memos          | POST      | {"title": "게시글1", "username":"반원재", "contents":"내용입니다"}      | {"id": 1, "title": "게시글1", "username":"반원재", "contents":"내용입니다", "createdAt": "2022/02/04 18:00:07"} |
| 게시글 전체 불러오기       | /api/memos | GET | {} | [{"id": 1, "title": "게시글1", "username":"반원재", "contents":"내용입니다", "createdAt": "2022/02/04 18:00:07"}, ...] |
| 상세페이지 조회  | /api/lookup | GET| {}       | {"id": 1, "title": "게시글1", "username":"반원재", "contents":"내용입니다", "createdAt": "2022/02/04 18:00:07"} |
| 댓글 조회      | /api/lookup/reply  | GET | {}  |  {"id": 2, "idInput": 3, "username":"반원재", "contents":"댓글입니다", "createdAt": "2022/02/04 18:00:07"} |
| 댓글 작성      | /api/replies  | POST | {"idInput": 3, "username":"반원재", "contents":"댓글입니다"}  |  {"id": 2, "idInput": 3, "username":"반원재", "contents":"댓글입니다", "createdAt": "2022/02/04 18:00:07"} |
| 댓글 수정     | /api/replies/fixing  | POST | {"idGiven": 1, "idInput": 3, "username":"반원재", "contents":"댓글수정입니다"}  |  {}|
| 댓글 삭제     | /api/replies/deleting  | POST | {"idGiven": 1}  |  {}|




## Built With
JAVA
* [Spring boot](https://spring.io/projects/spring-boot)  - Server 구축
* [MYSQL](https://pymongo.readthedocs.io/en/stable/) - DB
* [Spring Security](https://spring.io/projects/spring-security) -로그인 및 로그아웃 처리


JavaScript
* [jQuery](https://jquery.com) - AJAX 통신

CSS
* [Bootstrap](https://getbootstrap.com)
* [Google Fonts](https://fonts.google.com)

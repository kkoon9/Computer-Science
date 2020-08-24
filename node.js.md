# Node.js 
## 1. bin/www app.js
### Question
- Express 3.x에서는 app.js에 라우팅 및 미들웨어, 서버 및 포트 설정을 정의하고 노드 app.js로 노드를 시작했었습니다.
- 근데 Express 4.x 부터는 ./bin/www를 사용합니다.
- ./bin/www를 사용하는 이유가 무엇일까요?
### Answer
- Express 3.0에서는 일반적으로 app.configure() 또는 app.use ()를 사용하여 필요한 필수 미들웨어를 설정합니다. 지정한 미들웨어는 Express 3.0과 함께 번들로 제공됩니다.
- 그러나 Express 4.0에서는 모든 미들웨어가 제거되어 핵심 Express (정적 미들웨어 제외)와 **독립적으로 유지 보수 및 업데이트** 될 수 있으므로 별도로 호출해야합니다 (app.js에 표시).
- bin / 디렉토리는 다양한 시작 스크립트를 정의 할 수있는 위치로 사용됩니다. www는 express 앱을 웹 서버로 시작하는 예입니다.
- 궁극적으로 테스트, 중지 또는 다시 시작 등과 같은 다른 스크립트를 가질 수 있습니다.이 구조를 사용하면 모든 것을 app.js에 넣지 않고도 다른 시작 구성을 가질 수 있습니다.

### Finally
- 모든 미들웨어는 static middleware를 제외한 core Express로부터 독립적으로 유지 및 업데이트가 되어야 하기 때문에 제거되야 합니다.
- 따라서 그들은 별도로 호출되어야 합니다.

[출처](https://stackoverflow.com/questions/23169941/what-does-bin-www-do-in-express-4-x)

## bin/www
- http 모듈에 express 모듈을 연결하고 포트를 지정하는 부분
- #!/usr/bin/env node 라는 주석은 www 파일을 콘솔 명령어로 만들어준다.
```js
/**
* 
*/
var app = require('../app');
var debug = require('debug')('learn-express:server');
var http = require('http');

/**
* app.set('port', port)로 서버가 실행될 포트를 설정한다.
* process.env 객체에 PORT 속성이 있다면 그 값을 사용하고, 없다면 기본값으로 3000번 포트를 이용하도록한다.
*/
var port = normailizePort(process.env.PORT || '3000');
app.set('port', port);

/**
* app 모듈이 createServer 메서드의 콜백 함수 역할을 한다.
*/
var server = http.createServer(app);

server.listen(port);
server.on('error', onError);
server.on('listening, onListening);

```

## 구조
- 모델 - 경로 - 컨트롤러 - 서비스 디렉터리 구조를 갖는 것이 유지보수에 적합하다.
    * 모델 : 모델 의 스키마 정의
    * 경로 : API 경로가 컨트롤러에 매핑
    * 컨트롤러 : 요청 매개 변수 확인, 쿼리, 올바른 코드로 응답 보내기의 모든 로직을 처리
    * 서비스 : 데이터베이스 쿼리와 반환 객체 또는 오류 발생이 포함
- 예
```
├───models
│   ├───user.model.js
├───routes
│   ├───user.route.js
├───services
│   ├───user.service.js
├───controllers
│   ├───user.controller.js
```

## 에러 메시지
-  RangeError [ERR_HTTP_INVALID_STATUS_CODE]: Invalid status code: undefined
- service에서 json형태로 보내주고 code는 안보내줬는데
- res.status(code).send(json) 형식으로 controller에서 받아서 생긴 오류

- Error: Route.get() requires a callback function but got a [object Undefined]
    - service와 controller에 있는 mix를 주석처리하고 실행하여 생긴 오류

- (node:7980) UnhandledPromiseRejectionWarning: TypeError: Blog.findAll is not a function
- model을 가져올 때 index.js를 가져와야한다.
- index에 db.Blog를 선언했기 때문이다.
- 그리고 models/index에 선언한 그대로 가져와야한다.

- (node:16136) UnhandledPromiseRejectionWarning: SequelizeUniqueConstraintError: Validation error
- 
User.create ()를 호출하면 Promise.reject ()를 반환하지만 처리 할 .catch (err)가 없습니다. 오류를 포착하고 입력 값을 알지 못하면 유효성 검사 오류가 무엇인지 말하기 어렵습니다.

- SequelizeDatabaseError: Illegal mix of collations (latin1_swedish_ci,IMPLICIT) and (utf8mb4_unicode_ci,COERCIBLE) for operation '='

- "operatorsAliases": 0
    - config 파일에서 operatorsAiases를 false로 해놔서 한글이 차단당했다. 그렇기때문에 create 부분에서 오류가 발생했다.
- RDS default를 utf8로 설정해야한다.
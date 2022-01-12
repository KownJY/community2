// {
//     let idBtnChkElem = joinFrmElem.querySelector('#id-btn-chk');
//     let joinFrmElem = document.querySelector('#join-Frm');
//     let idChk = 2; //아이디 중복체크를 하였는지 안했는지 판단하는 변수.
//                     //2 체크안함 , 1 아이디 사용가능  0 아이디 사용불가
//
//
//     // 이거는 함수로 따로 만들었음//fetch에 data에 넣는 부분
//     let setIdChkMsg = (data) =>{
//
//         idChk=data.result; //여기엔 현재 0아니면 1
//         switch (data.result){
//             case 0:
//                 idChkMsgElem.innerText = "아이디 불가능해욧 >_<"
//                 break;
//             case 1:
//                 idChkMsgElem.innerText = "아이디 사용 가능해용 ^^"
//                 break;
//         }
//
//
//     };
//
//     if (joinFrmElem) {
//         joinFrmElem.addEventListener('submit', (e)=>{
//
//             if(idChk !== 1){
//
//                 switch (idChk){
//                     case 0:
//                         alert('다른아이디 사용 해주세요');
//                         break;
//                     case 2:
//                         alert('아이디 중복 확인을 해주세요');
//                         break;
//                 }
//                 e.preventDefault();
//             }
//
//         });
//
//         //여기가 아이디 변경하면 스팬 지워주고 중복체크 풀어주는곳
//         joinFrmElem.uid.addEventListener('keyup',() => {
//             let idChkMsgElem =joinFrmElem.querySelector('#id-Chk-Msg');
//             idBtnChkElem.innerText= ''; //여기가 스판 지워지는부분?
//            idChk =2;
//         })
//
//
//
//
//         idBtnChkElem.addEventListener('click', () => {
//
//             let idVal = joinFrmElem.uid.value;
//
//             if (idVal.length < 2) {
//                 alert('아이디는 2자 이상 작성좀해주세요;');
//                 return;
//             }
//             fetch('/user/idChk/${idVal}')
//                 .then(res => res.json())
//                 .then((data) => {
//                     console.log(data);
//                         setIdChkMsg(data);
//                 }).catch((e) => {
//                 console.log(e)
//             });
//             //패치가뭐야
//
//         });
//     }
//
//
// }


//
// {
//     let idChkState = 2; //0: 아이디 사용 불가능, 1:아이디 사용가능, 2: 체크 안함
//     const joinFrmElem = document.querySelector('#join-frm');
//     const idRegex = /^([a-zA-Z0-9]{4,15})$/;
//     const pwRegex = /^([a-zA-Z0-9!@_]{4,15})$/; //대소문자 + 숫자랑 !@만 되고 4-20글자 인 경우만 ㅇㅋ
//     const nmRegex =/^([가-힣]{2,5})/;
//     const msg1 = "뀨뀨꺄꺄꺄꿍";
//
//     const setIdChkMsg = (data) => {
//         idChkState = data.result; //0 or 1
//
//         const idChkMsgElem = joinFrmElem.querySelector('#id-chk-msg');
//         switch (data.result) {
//             case 0:
//                 idChkMsgElem.innerText = '이미 사용중인 아이디 입니다.';
//                 break;
//             case 1:
//                 idChkMsgElem.innerText = '사용할 수 있는 아이디 입니다.';
//                 break;
//         }
//     };
//
//     if (joinFrmElem) {
//         joinFrmElem.addEventListener('submit', (e) => {
//
//             const uid = joinFrmElem.uid.value;
//             const upw = joinFrmElem.upw.value;
//             const nm = joinFrmElem.nm.value;
//             const upwChk = joinFrmElem.querySelector('#upw-chk');
//             if(!idRegex.test(uid)){
//                 alert('아이디는 대소문자 조합으로 4-15글자.');
//                 e.preventDefault();
//             }else if(!pwRegex.test(upw)){
//                 alert('비번은 대소문자 숫자 ! @ 조합으로 4-15글자.');
//                 e.preventDefault();
//             }else if(upw != upwChk){
//                 alert('비밀번호와 비밀번호확인을 확인을 확인을 해라.');
//                 e.preventDefault();
//             }
//             else if(!nmRegex.test(nm)){
//                 alert('이름은 한글로 2 - 5 글자..');
//                 e.preventDefault();
//             }
//
//             if (idChkState !== 1) {
//                 switch (idChkState) {
//                     case 0:
//                         alert('다른 아이디를 사용해 주세요!');
//                         break;
//                     case 2:
//                         alert('아이디 중복 체크를 해주세요!');
//                         break;
//                 }
//                 e.preventDefault();
//             }
//         });
//
//         joinFrmElem.uid.addEventListener('keyup', () => {
//             const idChkMsgElem = joinFrmElem.querySelector('#id-chk-msg');
//             idChkMsgElem.innerText = '';
//             idChkState = 2;
//         });
//
//         //아이디 중복 체크 버튼
//         const idBtnChkElem = joinFrmElem.querySelector('#id-btn-chk');
//         idBtnChkElem.addEventListener('click', () => {
//             const idVal = joinFrmElem.uid.value;
//
//             if (idVal.length < 4) {
//                 alert('아이디는 4자 이상 작성해 주세요.');
//                 return;
//             }
//
//             if(!idRegex.test(idVal)){
//                 alert("아이디 상태가 불량");
//                 return;
//             }
//
//
//
//             fetch(`/user/idChk/${idVal}`)
//                 .then(res => res.json())
//                 .then((data) => {
//                     setIdChkMsg(data);
//                 }).catch((e) => {
//                 console.log(e);
//             });
//         });
//     }
// }

let joinFrmElem = document.querySelector('#join-frm');

if(joinFrmElem){
    joinFrmElem.addEventListener('click',(e)=>{

        let uid = joinFrmElem.uid.value;
        if(uid == ''){
            alert("아이디가 없사오...");
            e.preventDefault();
        }
    })
}

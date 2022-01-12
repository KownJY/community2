
// let frm = document.querySelector('.frm');
// if(frm){
//     let btnDel = document.querySelector('#btnDel')
//     btnDel.addEventListener('click',()=>{
//         let condel = confirm("삭제하시겠어요?");
//         if(condel == true){
//             location.href = `/board/del?iboard=${iboard}`;
//         }else{
//             location.href=`/board/detail?iboard=${iboard}`;
//         }
//     })
//
// }

{
    const dataElem  = document.querySelector('#data')
    const delBtnElem = document.querySelector('#Delbtn')

    if(delBtnElem){
        delBtnElem.addEventListener('click',()=>{
            const icategory =dataElem.dataset.icategory;
            const iboard = dataElem.dataset.iboard;
            if(confirm(msg.fnIsDel(`${iboard}번의 글`))){
                location.href = `/board/del?icategory=${icategory}&iboard=${iboard}`;
            }
        });
    }

    const modBtnElem = document.querySelector('#Modbtn')
    if(modBtnElem){
        modBtnElem.addEventListener('click',()=>{
            const iboard = dataElem.dataset.iboard;
            location.href=`/board/mod?iboard=${iboard}`;
        })
    }
}

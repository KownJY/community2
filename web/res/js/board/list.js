// function moveToDetail(iboard) {
//     location.href='/board/detail?iboard=' + iboard;
// }
//
// var trList = document.querySelectorAll('.record');
// for(var i=0; i<trList.length; i++) {
//     setEvent(trList[i]);
// }
//
// function setEvent(tr) {
//     tr.addEventListener('click', function() {
//         moveToDetail(tr.dataset.iboard);
//     });
// }

{
    const recordList = document.querySelectorAll('.record');
    recordList.forEach((item) => {
        item.addEventListener('click', (e) => {
            const iboard = item.dataset.iboard;
            console.log(iboard);
            location.href = `/board/detail?iboard=${iboard}`;
        });
    });
}
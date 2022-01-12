{
    const dataElem = document.querySelector('#data') //data element

    const profileFileElem = document.querySelector('#profile-file')
    if (profileFileElem) {
        profileFileElem.addEventListener('change', () => {
            const img = profileFileElem.files[0];
            if (img != null) {
                uploadProfileImg(img);
            }
        })
    }

    const profileVieElem = document.querySelector('#profile-view')
    if (profileVieElem) {
        profileVieElem.addEventListener('click', () => {
            if (profileFileElem) {
                profileFileElem.click();
            }
        })
    }


    const uploadProfileImg = (img) => {
        const fData = new FormData();
        fData.append('profileimg', img);

        fetch('/user/mypage/profile', {
            'method': 'post',
            'body': fData
        })
            .then(res => res.json())
            .then(data => {
                console.log(data);
                setProfileImg(data);
            })
            .catch(e => {
                console.log(e);
            });
    }

    const setProfileImg = (data) => {
        if (!data.result) {
            return;
        }

        const iuser = dataElem.dataset.iuser;
        const img = profileVieElem.querySelector('img');
        img.src =`/images/user/${iuser}/${data.result}`;
    }
}
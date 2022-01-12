const msg = {
    'isdel' : '삭제하겠어요?',

    'fnIsDel' : function(target){
        return `${target}을` + this.isdel;
    }
}
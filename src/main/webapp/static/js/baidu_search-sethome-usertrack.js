
(function(){var event=T.event,dom=T.dom;event.on("search-text-con","click",function(e){var e=event.get(e),target=e.target,attr=dom.getAttr(target,"search-des");if(attr){var oAllLi=document.getElementById("search-text-con").getElementsByTagName("li"),length=oAllLi.length,selected=null;for(var i=0;i<length;i++){selected=oAllLi[i];if(dom.hasClass(selected,"selected")){dom.removeClass(selected,"selected");break;}}
dom.addClass(target.parentNode,"selected");T.g("search-input-word").focus();haoValidate(T.g("baidu-search-sub"),attr);e.preventDefault();}if(attr=="video"){T.g("search-input-word").name="q";}else{T.g("search-input-word").name="word";}var sug_url="http://nssug.baidu.com/su";var requestParas={"prod":attr};var requestQuery="wd";var callbackFn="baidu.sug";var callbackDataKey="s";switch(attr){case"web":sug_url="http://suggestion.baidu.com/su";break;case"tieba":requestParas={callback:"baiduSugTieba",sc:"hao123"};sug_url="http://tieba.baidu.com/sug";requestQuery="query";callbackFn="baiduSugTieba";callbackDataKey="msg";break;case"img":attr="image";requestParas={"prod":attr};break}testSug=G.sug("search-input-word",{classNameQuery:"sug-query",classNameQueryNull:"sug-querynull",charset:"gbk",requestQuery:requestQuery,requestParas:requestParas,url:sug_url,callbackFn:callbackFn,callbackDataKey:callbackDataKey});});function haoValidate(f,value){if(value=="tieba")
{f.action="http://tieba.baidu.com/f";}
else if(value=="img")
{f.action="http://image.baidu.com/i";T.g("search-args").innerHTML='<input type="hidden" name="tn" value="baiduimage"><input type="hidden" name="ct" value="201326592"><input type="hidden" name="cl" value="2"><input type="hidden" name="lm" value="-1"><input type="hidden" name="fm" value="hao123">';}
else if(value=="zhidao")
{f.action="http://zhidao.baidu.com/q";T.g("search-args").innerHTML='<input type="hidden" name="tn" value="ikaslist"><input type="hidden" name="ct" value="17"><input type="hidden" name="sc" value="hao123"><input type="hidden" name="rn" value="20">'}
else if(value=="web")
{f.action="http://www.baidu.com/s";T.g("search-args").innerHTML='<input type="hidden" name="rsv_bp" value="0"><input type="hidden" name="rsv_spt" value="3">';}
else if(value=="mp3")
{f.action="http://mp3.baidu.com/m";T.g("search-args").innerHTML='<input type="hidden" name="tn" value="baidump3"><input type="hidden" name="ct" value="134217728"><input type="hidden" name="sc" value="hao123">';}
else if(value=="news")
{f.action="http://news.baidu.com/ns";T.g("search-args").innerHTML='<input type="hidden" name="tn" value="news"><input type="hidden" name="sc" value="hao123">';}
else if(value=="video"){f.action="http://v.yisou.com/s";T.g("search-args").innerHTML='<input type="hidden" name="charset" value="gbk"><input type="hidden" name="sr" value="1"><input type="hidden" name="cid" value="4392">';}
return true;};})();
var UA=(function(WIN,UA){var key={ie:"msie",sf:"safari",tt:"tencenttraveler"},reg={browser:"("+key.ie+"|"+key.sf+"|firefox|chrome|opera)",shell:"(maxthon|360se|theworld|se|theworld|greenbrowser|qqbrowser)",tt:"(tencenttraveler)",os:"(windows nt|macintosh|solaris|linux)"},uaMatch=function(str){var reg=new RegExp(str+"\\b[ \\/]?([\\w\\.]*)","i"),result=UA.match(reg);return result?result.slice(1):["",""];},is360=function(){var result=UA.toLowerCase().indexOf("360chrome")>-1?!!1:!1,s;try{if(WIN.external&&WIN.external.twGetRunPath){s=WIN.external.twGetRunPath;if(s&&s.toLowerCase().indexOf("360se")>-1){result=!!1;}}}catch(e){result=!1}
return result;}(),maxthonVer=function(){try{if(/(\d+\.\d)/.test(external.max_version)){return parseFloat(RegExp['\x241']);}}catch(e){}}(),browser=uaMatch(reg.browser),shell=uaMatch(reg.shell),os=uaMatch(reg.os);if(browser[0].toLowerCase()===key.ie){if(is360){shell=["360se",""];}else if(maxthonVer){shell=["maxthon",maxthonVer];}else if(shell==","){shell=uaMatch(reg.tt);}}else if(browser[0].toLowerCase()===key.sf){browser[1]=uaMatch("version")+"."+browser[1];}
return{browser:browser.join(","),shell:shell.join(","),os:os.join(",")};})(window,navigator.userAgent);var indexSetHome={config:{helpUrl:"http://www.hao123.com/redian/sheshouyef.htm",shell:{"360se":"02","maxthon":"03","se":"04","qqbrowser":"05","theworld":"10","greenbrowser":"12"},browser:{"firefox":"ff","chrome":"08","opera":"09","safari":"11"}},set:function(el,url){var browser=UA.browser.split(",")[0].toLowerCase(),shell=UA.shell.split(",")[0].toLowerCase(),config=this.config,helpUrl=config.helpUrl,errorTip="�����������֧�֣����ֶ�����",setForIE=function(){try{el.style.behavior='url(#default#homepage)';el.setHomePage(url);}catch(e){alert(errorTip);}};if(browser==="msie"&&(!shell||shell==="tencenttraveler")){setForIE();return false;}else if(shell&&config.shell[shell]){helpUrl+="#"+config.shell[shell];if(shell==="maxthon"){try{if(external.max_version){window.open(helpUrl);return false;}else{setForIE();return false;}}catch(e){setForIE();return false;}}else{window.open(helpUrl);return false;}}else if(config.browser[browser]){if(browser==="chrome"){try{if(external.max_version){helpUrl+="#"+"03";window.open(helpUrl);return false;}else{helpUrl+="#"+config.browser[browser];window.open(helpUrl);return false;}}catch(e){helpUrl+="#"+config.browser[browser];window.open(helpUrl);return false;}}else{helpUrl+="#"+config.browser[browser];window.open(helpUrl);return false;}}else{alert(errorTip);return false;}},bind:function(el,url){el=typeof el==="string"?document.getElementById(el):el;if(el.href.indexOf("hao123.com")<0)return;url=url||el.href||window.location;var that=this,on=document.addEventListener?function(el,type,callback){el.addEventListener(type,callback,!1);}:function(el,type,callback){el.attachEvent("on"+type,callback);};on(el,"click",function(){that.set(el,url);return false;});return this;}}
var UserTrack={send:function(oparam){var aparam=[],odefault=UserTrack._default,onosend=UserTrack._nosendParam;_hao123_image=new Image(1,1);oparam=oparam||odefault;oparam.randnum=Math.round(Math.random()*2147483647);oparam.sendurl=oparam.sendurl||odefault.sendurl;oparam.refer=oparam.refer||odefault.refer;oparam.type=oparam.type||odefault.type;for(var key in oparam){if(!onosend[key])
aparam.push(encodeURIComponent(key)+"="+encodeURIComponent(oparam[key]));}
_hao123_image.src=oparam.sendurl+"?"+aparam.join("&");_hao123_image.onload=function(){_hao123_image.onload=null;};},click:function(e){var e=e||window.event,op={type:"click"},odom=e.target||e.srcElement||document;if(odom.nodeName.toUpperCase()=="A"){op.tit=odom.innerText||odom.textContent;op.url=odom.href;UserTrack.send(op);}},_default:{sendurl:"http://www.hao123.comm/images/track.gif",refer:document.referrer,type:"access"},_nosendParam:{sendurl:true}}
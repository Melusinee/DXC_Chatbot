function clearPlaceHolder(){
  document.getElementById("text-input-text").innerHTML = "";
}

function getInputField(){
  return document.getElementById("text-input");
}

function getUserMessageTemplate(){
  return document.getElementsByClassName("flex message d-flex message-human")[0];
}

function getBotMessageTemplate(){
  return document.getElementsByClassName("flex message d-flex message-bot")[0];
}

function getConversationComponent(){
  return document.getElementsByClassName("layout message-list column fill-height")[0];
}

function sendUserMessage(e){
  if (e.keyCode == 13) {
      var parent = getConversationComponent();
      var childrenTemplate = getUserMessageTemplate();
      var newChildren = childrenTemplate.cloneNode(true);
      var inputField = getInputField();
      var sendingMessage =  inputField.value;

      if(sendingMessage=="")
        return;

      newChildren.getElementsByClassName("message-text")[0].innerHTML = sendingMessage;
      parent.appendChild(newChildren);
      deliverMessageToBot(sendingMessage,parent);
      inputField.value = "";
    }
}

function deliverMessageToBot(message,parent){
        var request = $.ajax({
            url: "/botResponse?message="+message,
            type: "GET"
        });

        request.done(function(msg) {
            console.log(msg);
            var newChildren = getBotMessageTemplate().cloneNode(true);
            newChildren.getElementsByClassName("message-text")[0].innerHTML = msg;
            parent.appendChild(newChildren);
            console.log('succesful call');
        });

        request.fail(function(jqXHR, textStatus) {
            console.log('failed call');
        });

        event.preventDefault();
}

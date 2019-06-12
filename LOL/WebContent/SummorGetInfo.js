function DisplaySummorInfo(){
			$("#btn").on("click", function() {
				var requestApiSummoner ="https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/";
				var riot_codeKey = "?api_key=RGAPI-928b83d4-ad22-4ed4-a368-240e2900b55a";
				var id = document.getElementById("ID").value;
				$.ajax({
					url : requestApiSummoner+id+riot_codeKey,
					dataType:'jsonp',
					async:false,
					error : function(data) {
						 $('#show').html(JSON.stringify(data));
					},
					success:function(data){
						 $('#show').html(JSON.stringify(data));
					}
				});
			});
		}

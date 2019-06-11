
var requestApiSummoner ="https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/";
var riot_codeKey = "?api_key=RGAPI-92af9cc1-3dff-46a7-a5c4-d82df8ceb612";
var id = 
		$(function() {
			$("btn").on("click", function() {
				$.ajax("/examples/media/request_ajax.php")
				.done(function() {
					alert("요청 성공");
				})
				.fail(function() {
					alert("요청 실패");
				})
				.always(function() {
					alert("요청 완료");
				});
			});
		});

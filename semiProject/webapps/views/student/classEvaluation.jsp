<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강의평가</title>
<script src="/semiProject/resources/js/jquery-3.5.1.min.js"></script>
<link href="/semiProject/resources/assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<style>
	.table {

		text-align : center;
		margin : auto;
	}

	.table tr td:nth-of-type(2){
		text-align : left;
	}
	
	.title {
		background-color: #F3F3F3;
	}

	#button{
		text-align : center;
	}
</style>
</head>
<body>
	<form method="get">
		<div class="table-responsive">
			<table class="table">
				<thead class="title">
					<tr>
						<td colspan="2">공통 강의 평가</td>
						<td>매우 그렇다</td>
						<td>그런편이다</td>
						<td>보통 이다</td>
						<td>그렇지 않다</td>
						<td>전혀 그렇지 않다</td>
					</tr>
				</thead>
				<tbody>
					<tr class="title">
						<td colspan="2">* 강의 평가</td>
						<td style="text-align : center;">5</td>
						<td>4</td>
						<td>3</td>
						<td>2</td>
						<td>1</td>
					</tr>
					<tr>
						<td>1</td>
						<td>강의 계획서는 강의 목표, 내용, 방법, 평가 등에 대한 사항을 충분히 안내하였는가?</td>
						<td><input type="radio" name="a" value="a5"></td>
						<td><input type="radio" name="a" value="a4"></td>
						<td><input type="radio" name="a" value="a3"></td>
						<td><input type="radio" name="a" value="a2"></td>
						<td><input type="radio" name="a" value="a1"></td>
					</tr>
					<tr>
						<td>2</td>
						<td>강의 내용은 자신에게 학습 욕구를 불러일으킬 만큼 적절한 수준이었는가?</td>
						<td><input type="radio" name="b" value="b5"></td>
						<td><input type="radio" name="b" value="b4"></td>
						<td><input type="radio" name="b" value="b3"></td>
						<td><input type="radio" name="b" value="b2"></td>
						<td><input type="radio" name="b" value="b1"></td>
					</tr>
					<tr>
						<td>3</td>
						<td>이 강의를 통하여 해당 교과목에 대한 이해가 개선되었는가?</td>
						<td><input type="radio" name="c" value="c5"></td>
						<td><input type="radio" name="c" value="c4"></td>
						<td><input type="radio" name="c" value="c3"></td>
						<td><input type="radio" name="c" value="c2"></td>
						<td><input type="radio" name="c" value="c1"></td>
					</tr>
					<tr>
						<td>4</td>
						<td>이 강의를 통하여 다른 강의에서 접할 수 없는 새로운 내용을 배울 수 있었는가?</td>
						<td><input type="radio" name="d" value="d5"></td>
						<td><input type="radio" name="d" value="d4"></td>
						<td><input type="radio" name="d" value="d3"></td>
						<td><input type="radio" name="d" value="d2"></td>
						<td><input type="radio" name="d" value="d1"></td>
					</tr>
					<tr>
						<td>5</td>
						<td>교수는 주요 주제들간의 관계가 드러나도록 내용을 구조화하여 전달하였는가?</td>
						<td><input type="radio" name="e" value="e5"></td>
						<td><input type="radio" name="e" value="e4"></td>
						<td><input type="radio" name="e" value="e3"></td>
						<td><input type="radio" name="e" value="e2"></td>
						<td><input type="radio" name="e" value="e1"></td>
					</tr>
					<tr>
						<td>6</td>
						<td>교수는 열정을 갖고 수업에 진행하였는가?</td>
						<td><input type="radio" name="f" value="f5"></td>
						<td><input type="radio" name="f" value="f4"></td>
						<td><input type="radio" name="f" value="f3"></td>
						<td><input type="radio" name="f" value="f2"></td>
						<td><input type="radio" name="f" value="f1"></td>
					</tr>
					<tr class="title">
						<td colspan="2" >* 수업에 관련된 내용</td>
						<td style="text-align : center;">5</td>
						<td>4</td>
						<td>3</td>
						<td>2</td>
						<td>1</td>
					</tr>
					<tr>
						<td>7</td>
						<td>수업시간은 제대로 이루어졌는가?</td>
						<td><input type="radio" name="g" value="g5"></td>
						<td><input type="radio" name="g" value="g4"></td>
						<td><input type="radio" name="g" value="g3"></td>
						<td><input type="radio" name="g" value="g2"></td>
						<td><input type="radio" name="g" value="g1"></td>
					</tr>
					<tr>
						<td>8</td>
						<td>강의 내용이 과목명이랑 부합하는가?</td>
						<td><input type="radio" name="h" value="h5"></td>
						<td><input type="radio" name="h" value="h4"></td>
						<td><input type="radio" name="h" value="h3"></td>
						<td><input type="radio" name="h" value="h2"></td>
						<td><input type="radio" name="h" value="h1"></td>
					</tr>
					<tr>
						<td>9</td>
						<td colspan="6">이 강의의 장점과 개선이 필요한 점을 구체적으로 기술하시오.</td>
					</tr>
					<tr>
						<td colspan="7">
							<textarea name="" id="" cols="100" rows="10" style="resize: none;"></textarea>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div id="button">
			<button class="btn btn-primary" onclick="return evalSubmit();">작성 완료</button>
					&nbsp;
			<button class="btn btn-secondary" onclick="cancel();">작성 취소</button>
		</div>
	</form>
	<script>
		function cancel(){
			var check = window.confirm('정말 종료하시겠습니까? 작성 내용은 저장되지 않습니다.');
			if(check){
				window.close();
			}
		}
				
		function evalSubmit(){
			var check = window.confirm('이대로 제출하시겠습니까? 제출 후 수정은 불가능합니다.');
			if(check){
				window.close();
				return true;
			} else {
				return false;
			}
		}
	</script>
</body>
</html>
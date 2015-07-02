AWS lambdaサンプル
===============

# ビルド方法
buildZipタスクを実行すればzipファイルが作成されるので、アップロードしてlambda function を登録する。


## テスト実行を想定したサンプル
example.Hello::myHandler
をハンドラに設定する。

IAMロールは「lambda_basic_execution」を言われるままに自動設定

起動方法は、lambda のテスト画面からInvokeを押下。

## S3のイベント契機のサンプル
example.S3Sample::handleRequest
をハンドラに設定する。

また、lambda 登録後、S3/create object のイベントにひもづけを行う。

IAMロールは「lambda_s3_exec_role」を言われるままに自動設定

起動方法は、S3のバケットにファイルをアップロード。
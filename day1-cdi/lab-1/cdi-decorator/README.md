# サンプルコードの動作確認方法

1. JBoss EAP サーバを起動します。

~~~
$ ${EAP_HOME}/bin/standalone.sh
~~~

2. サンプルアプリケーションをビルドします。

~~~
$ mvn clean package
~~~

3. サンプルアプリケーションをEAPにデプロイします。

~~~
$ mvn deploy
または、
$ mvn wildfly:deploy-only
~~~

4. ブラウザで以下のURLにアクセスします。

~~~
http://localhost:8080/cdi-decorator-web/
~~~
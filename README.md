# ems_parent
仅仅只是学习笔记

启动consul<br>
windows: consul agent -dev<br>
linux: ./consul agent -dev -ui -node=consul-dev -client=0.0.0.0<br>
docker: docker run -d -p 8500:8500 --name=consul --restart=always consul:latest agent -server -bootstrap -ui -node=1 -client='0.0.0.0'

move:
	cls
	mvn clean -f "d:\MinecraftDev\MinecraftPlugins\MultiWorld\multiworld\pom.xml"
	mvn package -f "d:\MinecraftDev\MinecraftPlugins\MultiWorld\multiworld\pom.xml
	del "D:\MinecraftServer\Test\plugins\multiworld-1.0.jar"
	move "D:\MinecraftDev\MinecraftPlugins\MultiWorld\multiworld\target\multiworld-1.0.jar" "D:\MinecraftServer\Test\plugins"
	mvn clean -f "d:\MinecraftDev\MinecraftPlugins\MultiWorld\multiworld\pom.xml"
	cd D:\MinecraftServer\Test && java -Xmx1G -Xms1G -jar server.jar nogui
	cls
# technical-exercise

To load data to OSS Redis

ubuntu@ip-172-31-9-119:~/tech-excercise$ java -classpath lib/jedis-2.9.0.jar:. com/jedis/test/App 172.31.9.119 6379 load

To read data from enterprise redis

ubuntu@ip-172-31-2-150:~/tech-excecise$ java -classpath lib/jedis-2.9.0.jar:. com/jedis/test/App 172.31.2.150 27302 read x8lgDb6ZdzmOFKiMWYcnzfRBPqWXrcM9h15XYBaNBfJNalBT

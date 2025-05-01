#!/bin/env sh

echo '@timestamp@'
echo '${timestamp}'
echo '@maven.build.timestamp@'
echo '${maven.build.timestamp}'
echo '@my.name@'
echo '${my.name}'

# - figure out proper %catalina_base% value to use
# - set the environment variables
# - xcopy over items from %catalina_home% like ./conf
# - call %cataline_home%/bin/start %1 %2 %3
 
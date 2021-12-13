FROM ubuntu:20.04

RUN apt-get update && \
    apt-get install --no-install-recommends -y 

RUN rm /bin/sh && ln -s /bin/bash /bin/sh

ENV NVM_DIR /usr/local/nvm
ENV NODE_VERSION 16.11.1

RUN curl --silent -o- https://raw.githubusercontent.com/creationix/nvm/v0.33.2/install.sh | bash

RUN source $NVM_DIR/nvm.sh \
    && nvm install $NODE_VERSION \
    && nvm alias default $NODE_VERSION \
    && nvm use default \
    && nvm install 16.4.2 \
    && nvm use 16.4.2

ENV NODE_PATH $NVM_DIR/v$NODE_VERSION/lib/node_modules
ENV PATH $NVM_DIR/versions/node/v$NODE_VERSION/bin:$PATH

RUN npm install --global yarn

RUN yarn add global "@types/node"
RUN yarn add global "typescript"
RUN yarn add global ts-node

WORKDIR /JSServer

COPY package.json .

function task1(callback) {
    setTimeout(() => {
        console.log('Task1 completed.');
        callback();
    }, 1000); // Simulating an async operation
}

function task2(callback) {
    setTimeout(() => {
        console.log('Task2 completed.');
        callback();
    }, 1000); // Simulating an async operation
}

function task3() {
    setTimeout(()=> {
        console.log('Task3 completed');
    }, 1000); // Simulating an async operation
}

task1(() => {
    task2(() => {
        task3();
    });    
});
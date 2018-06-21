const ratings = require('../repository/ratings');

module.exports = function(context) {
    ratings.getCommentsForReview().then(result => {
        context.res = {
            body: result,
            headers: {
                "Content-Type": "application/json"
            }
        };
        
        context.done();
    });
};
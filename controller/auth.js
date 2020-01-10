const redirectLogin = (req, res, next) => {
	if (!req.session.userId) {
		res.redirect(`/signin`);
	} else {
		next();
	}
}

const customerRole = (req, res, next) => {
	console.log(req.session);
	if (req.session.type == `customerRole` && req.session.userId) {
		next();
	} else {
		res.status(401).send(`Unauthorized access!`);
	}
}

const shopkeeperRole = (req, res, next) => {
	console.log(req.session);
	if (req.session.type == `shopkeeperRole` && req.session.userId) {
		next();
	} else {
		res.status(401).send(`Unauthorized access!`);
	}
}

const redirectHome = (req, res, next) => {
 	if (req.session.userId && req.session.type == `shopkeeperRole`) {
		res.redirect(`/shopkeeperDash`);
	} else if (req.session.userId && req.session.type == `customerRole`) {
		res.redirect(`/customerDash`);
	} else {
		next();
	}
}

module.exports = {
	customerRole,
	redirectHome,
	shopkeeperRole
}

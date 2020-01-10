const user = require(`../models`).user;
const mail = require(`../utils/email`);

async function newUser(req, res) {
	if (status == `409`) {
		res.status(409).send(`User Already Exists`);
		return status;
	} else if (email == `405`) {
		res.status(405).send(`Invalid Email`);
	} else if (status != `409`) {
		let boardDetails = ``;
		let newUser = await user
			.build({
				name: req.body.name,
				email: req.body.email,
				password: req.body.password,
			})
			.save()
			.catch((error) => res.status(400).send(error));
		let HelperOptions = {
			from: `Deqode <saifullahf2608@gmail.com>`,
			to: newUser.email,
			subject: `Welcome to Deqode!`,
			text: `Email id: ${newUser.email}\nPassword: ${newUser.password}\nTrello Board Link: ${boardDetails.url}`
		};
		mail.sendMail(HelperOptions);
		res.render(`home`);
	}
}

async function login(req, res) {
	let existingUser = await user
		.findOne({
			where: {
				email: req.body.email,
				password: req.body.password
			}
		})
	if (!existingUser) {
		res.status(400).send(`Invalid Credentials`);
	} else {
		req.session.type = existingUser.type;
		req.session.userId = existingUser.id;
		console.log(req.session);
		res.redirect(`home`);
	}
}


async function profile(req, res) {
	let usr = await user
		.findByPk(req.session.userId)
	res.status(200).send(usr);
}

async function updateUser(req, res) {
	if (email != `405`) {
		if (existingUser != `404`) {
			if (userEmail != `409`) {
				if (req.params.id != req.session.userId) {
					res.status(401).send(`Unauthorized access`);
				} else {
					let userId = await user
						.findByPk(req.params.id)
					userId
						.update({
							name: req.body.name || userId.name,
							email: req.body.email || userId.email,
							password: req.body.password || userId.password
						})
						.catch((error) => {
							res.status(400).send(error);
						});
					res.status(200).send(userId);
				}
			} else {
				res.status(409).send(`Email Already Exists`);
			}
		} else {
			res.status(404).send(`User Does Not Exist`);
		}
	} else {
		res.status(405).send(`Invalid Email`);
	}
}


async function deleteUser(req, res) {
	let usr = await user
		.findByPk(req.params.id)
	if (!usr) {
		return res.status(400).send(`User Does Not Exist`);
	}
	return usr
		.destroy()
		.then(() => res.status(204).send(`Successful!!`))
		.catch((error) => res.status(400).send(error));
}


module.exports = {
	newUser,
	profile,
	updateUser,
	deleteUser,
	login,
};
